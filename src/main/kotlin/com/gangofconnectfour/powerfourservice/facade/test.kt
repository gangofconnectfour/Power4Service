package com.gangofconnectfour.powerfourservice.facade

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class Test {

    @GetMapping
    fun handle() : String {
        return "totot"
    }

}