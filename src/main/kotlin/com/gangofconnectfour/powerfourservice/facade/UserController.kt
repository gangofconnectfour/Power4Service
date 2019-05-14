package com.gangofconnectfour.powerfourservice.facade

import com.gangofconnectfour.powerfourservice.api.`in`.UserDtoIn
import com.gangofconnectfour.powerfourservice.facade.exception.UUIDException
import com.gangofconnectfour.powerfourservice.model.Profile
import com.gangofconnectfour.powerfourservice.model.User
import com.gangofconnectfour.powerfourservice.repository.UserRepository
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
class UserController(userRepository: UserRepository, bCryptPasswordEncoder: BCryptPasswordEncoder) {

    private var userRepository = userRepository;
    private var bCryptPasswordEncoder = bCryptPasswordEncoder

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody dtoIn: UserDtoIn, uriBuilder :UriComponentsBuilder) : ResponseEntity<Any> {
        var user = User(dtoIn)
        user.password = bCryptPasswordEncoder.encode(user.password)

        user = userRepository.save(user)

        val uri = uriBuilder.path("/api/users/{uuid}/details").buildAndExpand(user.uuid).toUri()
        return created(uri).build()
    }

    @GetMapping("/{uuid}/details")
    fun userDetail(@PathVariable("uuid") uuid : String) : User {
        var users = userRepository.findAll()
        var user = users.stream().filter { u -> u.uuid == uuid } .filter {u -> !u.userWS} .findFirst().get();
        return user
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun userUpdate(@RequestBody userUpdateDto : UserDtoIn){
        if (StringUtils.isEmpty(userUpdateDto.uuid)){
            throw UUIDException()
        }
        var user = userRepository.findByUuid(userUpdateDto.uuid!!)

        if (!StringUtils.isEmpty(userUpdateDto.email))
            user.email = userUpdateDto.email
        if (!StringUtils.isEmpty(userUpdateDto.encryptedPass))
            user.password = bCryptPasswordEncoder.encode(userUpdateDto.encryptedPass)
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
    fun allUsers() : List<User>{
        return userRepository.findAll().stream().filter {u -> !u.userWS} .collect(Collectors.toList());
    }



}