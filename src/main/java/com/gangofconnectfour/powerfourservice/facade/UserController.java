package com.gangofconnectfour.powerfourservice.facade;

import com.gangofconnectfour.powerfourservice.api.in.UserDtoIn;
import com.gangofconnectfour.powerfourservice.facade.exception.RessourceNotFoundException;
import com.gangofconnectfour.powerfourservice.facade.exception.UUIDException;
import com.gangofconnectfour.powerfourservice.model.Profile;
import com.gangofconnectfour.powerfourservice.model.User;
import com.gangofconnectfour.powerfourservice.repository.impl.UserService;
import com.gangofconnectfour.powerfourservice.utils.Closures;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("/api/users")
@Api(description = "Gestion des utilisateurs")
public class UserController {

    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Creer un user et renvoi l'url detail de celui ci.")
    public ResponseEntity createUser(@RequestBody UserDtoIn dtoIn, UriComponentsBuilder uriBuilder){
        User user = new User(dtoIn, false);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user = userService.save(user);

        URI uri = uriBuilder.path("/api/users/{uuid}/details").buildAndExpand(user.getUuid()).toUri();
        return created(uri).build();
    }

    @GetMapping("/{uuid}/details")
    @ApiOperation("Renvois les details d'un utilisateur")
    public User userDetail(@ApiParam("Id de l'utilisateur") @PathVariable("uuid")Long uuid ) throws RessourceNotFoundException {
        User user = userService.findByUuid(uuid);
        if (user == null || user.getUserWS()){
            throw new RessourceNotFoundException("user with uuid : " + uuid + ", not found");
        }
        return user;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation("Met a jour les information d'un utilisateur")
    public void userUpdate(@RequestBody UserDtoIn userUpdateDto ) throws UUIDException{
        if (StringUtils.isEmpty(userUpdateDto.getUuid())){
            throw new UUIDException();
        }
        User user = userService.findByUuid(userUpdateDto.getUuid());

        if (!StringUtils.isEmpty(userUpdateDto.getEmail()))
            user.setEmail(userUpdateDto.getEmail());
        if (!StringUtils.isEmpty(userUpdateDto.getPassword()))
            user.setPassword(bCryptPasswordEncoder.encode(userUpdateDto.getPassword()));
        if (!StringUtils.isEmpty(userUpdateDto.getNickname())) {
            user.setProfile(Closures.opt(user::getProfile).orElse(new Profile()));
            user.getProfile().setNickname( userUpdateDto.getNickname());
        }
        user.setUpdateAt(LocalDateTime.now());
        userService.save(user);
    }

    @GetMapping
    @ApiOperation("Liste tous les utilisateurs")
    public List<User> allUsers(@RequestParam("withAdmin") Boolean withAdmin) {
        List<User> users = userService.findAll();
        if (withAdmin)
            return users;
        else
            return users.stream().filter(u -> !u.getUserWS()).collect(Collectors.toList());
    }

}
