package com.gangofconnectfour.powerfourservice.facade

import com.gangofconnectfour.powerfourservice.api.`in`.UserDtoIn
import com.gangofconnectfour.powerfourservice.facade.exception.RessourceNotFoundException
import com.gangofconnectfour.powerfourservice.facade.exception.UUIDException
import com.gangofconnectfour.powerfourservice.model.Profile
import com.gangofconnectfour.powerfourservice.model.User
import com.gangofconnectfour.powerfourservice.repository.UserRepository
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.time.LocalDateTime
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/users")
@Api(description = "Gestion des utilisateurs")
class UserController(userRepository: UserRepository, bCryptPasswordEncoder: BCryptPasswordEncoder) {

    private var userRepository = userRepository;
    private var bCryptPasswordEncoder = bCryptPasswordEncoder

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Creer un user et renvoi l'url detail de celui ci.")
    fun createUser(@RequestBody dtoIn: UserDtoIn, uriBuilder: UriComponentsBuilder) : ResponseEntity<Any> {
        var user = User(dtoIn, false)
        user.password = bCryptPasswordEncoder.encode(user.password)

        user = userRepository.save(user)

        val uri = uriBuilder.path("/api/users/{uuid}/details").buildAndExpand(user.uuid).toUri()
        return created(uri).build()
    }

    @GetMapping("/{uuid}/details")
    @ApiOperation("Renvois les details d'un utilisateur")
    fun userDetail(@ApiParam("Id de l'utilisateur") @PathVariable("uuid") uuid : Long) : User {
        var user = userRepository.findByUuid(uuid);
        if (user == null || user.userWS){
            throw RessourceNotFoundException("user with uuid : " + uuid + ", not found")
        }
        return user
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation("Met a jour les information d'un utilisateur")
    fun userUpdate(@RequestBody userUpdateDto : UserDtoIn){
        if (StringUtils.isEmpty(userUpdateDto.uuid)){
            throw UUIDException()
        }
        var user = userRepository.findByUuid(userUpdateDto.uuid!!)

        if (!StringUtils.isEmpty(userUpdateDto.email))
            user.email = userUpdateDto.email
        if (!StringUtils.isEmpty(userUpdateDto.password))
            user.password = bCryptPasswordEncoder.encode(userUpdateDto.password)
        if (!StringUtils.isEmpty(userUpdateDto.nickname)) {
            if (user.profile == null) {
                user.profile = Profile()
            }
            user.profile.nickname = userUpdateDto.nickname
        }
        user.updateAt = LocalDateTime.now()
        user = userRepository.save(user);
    }

    @GetMapping
    @ApiOperation("Liste tous les utilisateurs")
    fun allUsers() : List<User>{
        return userRepository.findAll().stream().filter {u -> !u.userWS} .collect(Collectors.toList());
    }



}