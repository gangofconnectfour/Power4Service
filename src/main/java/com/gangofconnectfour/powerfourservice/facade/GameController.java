package com.gangofconnectfour.powerfourservice.facade;

import com.gangofconnectfour.powerfourservice.api.in.GameDtoIn;
import com.gangofconnectfour.powerfourservice.api.out.GameDtoOut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GameDtoOut> createGame(@RequestBody GameDtoIn dtoIn) {
        return ResponseEntity.ok().body(new GameDtoOut());
    }

}
