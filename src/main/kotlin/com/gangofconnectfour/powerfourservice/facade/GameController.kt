package com.gangofconnectfour.powerfourservice.facade

import com.gangofconnectfour.powerfourservice.api.`in`.GameDtoIn
import com.gangofconnectfour.powerfourservice.api.out.GameDtoOut
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/game")
class GameController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createGame(@RequestBody dtoIn: GameDtoIn) : ResponseEntity<GameDtoOut> {
        return ResponseEntity.ok().body(GameDtoOut());
    }

}