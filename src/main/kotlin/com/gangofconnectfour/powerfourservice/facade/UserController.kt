package com.gangofconnectfour.powerfourservice.facade

import com.gangofconnectfour.powerfourservice.api.`in`.UserDtoIn
import com.gangofconnectfour.powerfourservice.api.out.UserDtoOut
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody dtoIn: UserDtoIn) : ResponseEntity<UserDtoOut> {
        return ResponseEntity.ok().body(UserDtoOut())
    }

}