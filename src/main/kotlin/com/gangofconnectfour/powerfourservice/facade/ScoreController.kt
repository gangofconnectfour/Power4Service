package com.gangofconnectfour.powerfourservice.facade

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/score")
class ScoreController {

    @GetMapping("/game/{game_id}")
    fun scoreGame(@PathVariable("game_id") gameId: String) : List<String> {
        return Arrays.asList(gameId)
    }

    @GetMapping("/player/{player_id}")
    fun scorePlayer(@PathVariable("player_id") playerId :String) : List<String> {
        return Arrays.asList(playerId)
    }

}