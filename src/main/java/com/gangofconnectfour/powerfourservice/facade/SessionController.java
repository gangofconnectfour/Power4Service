package com.gangofconnectfour.powerfourservice.facade;

import com.gangofconnectfour.powerfourservice.api.in.SessionDtoIn;
import com.gangofconnectfour.powerfourservice.api.out.SessionDtoOut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SessionDtoOut> login(@RequestBody SessionDtoIn dtoIn) {
        return ResponseEntity.ok().body(new SessionDtoOut());
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<SessionDtoOut> logout(@RequestBody SessionDtoIn dtoIn) {
        return ResponseEntity.ok().body(new SessionDtoOut());
    }
}
