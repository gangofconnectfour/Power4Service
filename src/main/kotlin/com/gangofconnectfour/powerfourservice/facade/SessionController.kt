package com.gangofconnectfour.powerfourservice.facade

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/sessions")
class SessionController {

    @PostMapping
    fun login() {

    }

    @DeleteMapping
    fun logout() {

    }

}