package com.gangofconnectfour.powerfourservice.facade

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/test")
class Test {

    @GetMapping
    fun handle() : ResponseEntity<String> {
        return ResponseEntity.accepted().contentType(MediaType.APPLICATION_JSON).body(" {\"toto\" : \"toto\"}");
    }

}