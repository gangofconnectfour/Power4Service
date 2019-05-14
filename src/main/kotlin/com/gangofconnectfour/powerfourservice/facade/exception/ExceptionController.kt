package com.gangofconnectfour.powerfourservice.facade.exception

import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.badRequest
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class ExceptionController {

    @ExceptionHandler(UUIDException::class)
    fun handleException(ex: UUIDException): ResponseEntity<String> {
        return badRequest().body<String>(ex.message)
    }
}