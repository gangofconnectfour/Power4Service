package com.gangofconnectfour.powerfourservice.facade;

import com.gangofconnectfour.powerfourservice.api.out.ScoreDtoOut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/score")
public class ScoreController {

    @GetMapping("/game/{game_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<ScoreDtoOut> scoreGame(@PathVariable("game_id")Long gameId) {
        return ResponseEntity.ok().body(new ScoreDtoOut());
    }

    @GetMapping("/player/{player_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<ScoreDtoOut> scorePlayer(@PathVariable("player_id") Long playerId) {
        return ResponseEntity.ok().body(new ScoreDtoOut());
    }
}
