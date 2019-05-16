package com.gangofconnectfour.powerfourservice.facade.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.ResponseEntity.badRequest;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UUIDException.class)
    public ResponseEntity<String> handleException(UUIDException ex) {
        return badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(RessourceNotFoundException.class)
    public ResponseEntity<String> handleException(RessourceNotFoundException ex) {
        return badRequest().body(ex.getMessage());
    }
}
