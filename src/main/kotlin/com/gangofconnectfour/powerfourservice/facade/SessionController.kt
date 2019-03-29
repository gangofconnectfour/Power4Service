package com.gangofconnectfour.powerfourservice.facade

import com.gangofconnectfour.powerfourservice.api.`in`.SessionDtoIn
import com.gangofconnectfour.powerfourservice.api.out.SessionDtoOut
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/sessions")
class SessionController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun login(@RequestBody dtoIn : SessionDtoIn) : ResponseEntity<SessionDtoOut> {
        return ResponseEntity.ok().body(SessionDtoOut())
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun logout(@RequestBody dtoIn : SessionDtoIn) : ResponseEntity<SessionDtoOut> {
        return ResponseEntity.ok().body(SessionDtoOut())
    }

}