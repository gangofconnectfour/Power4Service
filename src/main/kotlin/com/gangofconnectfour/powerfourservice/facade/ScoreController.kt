package com.gangofconnectfour.powerfourservice.facade

import com.gangofconnectfour.powerfourservice.api.out.ScoreDtoOut
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/score")
class ScoreController {

    @GetMapping("/game/{game_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun scoreGame(@PathVariable("game_id") gameId: String) : ResponseEntity<ScoreDtoOut> {
        return ResponseEntity.ok().body(ScoreDtoOut())
    }

    @GetMapping("/player/{player_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun scorePlayer(@PathVariable("player_id") playerId :String) : ResponseEntity<ScoreDtoOut> {
        return ResponseEntity.ok().body(ScoreDtoOut())
    }

}