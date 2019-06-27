package com.gangofconnectfour.powerfourservice.facade;

import com.gangofconnectfour.powerfourservice.api.in.ScoreDtoIn;
import com.gangofconnectfour.powerfourservice.api.out.ScoreDetailDto;
import com.gangofconnectfour.powerfourservice.api.out.ScoreDtoOut;
import com.gangofconnectfour.powerfourservice.facade.exception.RessourceNotFoundException;
import com.gangofconnectfour.powerfourservice.model.MultiGame;
import com.gangofconnectfour.powerfourservice.model.SoloGame;
import com.gangofconnectfour.powerfourservice.model.User;
import com.gangofconnectfour.powerfourservice.repository.impl.MultiGameService;
import com.gangofconnectfour.powerfourservice.repository.impl.SoloGameService;
import com.gangofconnectfour.powerfourservice.repository.impl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/score")
public class ScoreController {

    private SoloGameService soloGameService;
    private MultiGameService multiGameService;
    private UserService userService;

    public ScoreController(SoloGameService soloGameService, MultiGameService multiGameService, UserService userService) {
        this.soloGameService = soloGameService;
        this.multiGameService = multiGameService;
        this.userService = userService;
    }

    @GetMapping("/game/{game_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ScoreDtoOut scoreGame(@PathVariable("game_id")Long gameId, @RequestBody ScoreDtoIn scoreDtoIn){
        ScoreDtoOut scoreDtoOut = null;
        if (scoreDtoIn.getVersusAi()){
            SoloGame soloGame = soloGameService.findById(gameId);
            scoreDtoOut = new ScoreDtoOut();
            scoreDtoOut.setScoreGame(new ScoreDetailDto(soloGame));
        } else {
            MultiGame multiGame = multiGameService.findById(gameId);
            scoreDtoOut = new ScoreDtoOut();
            scoreDtoOut.setScoreGame(new ScoreDetailDto(multiGame));
        }
        return scoreDtoOut;
    }

    @GetMapping("/player/{player_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ScoreDtoOut scorePlayer(@PathVariable("player_id") Long playerId, @RequestBody ScoreDtoIn scoreDtoIn) throws RessourceNotFoundException {
        ScoreDtoOut scoreDtoOut = new ScoreDtoOut();
        User user = userService.findByUuid(playerId);
        if (user == null) {
            throw new RessourceNotFoundException("ID => "+ playerId +"is not define");
        }
        List<ScoreDetailDto> scoreDetailDtos = new ArrayList<>();
        scoreDtoOut.setScorePlayer(scoreDetailDtos);
        if (scoreDtoIn.getVersusAi()){
            scoreDetailDtos.addAll(user.getSoloGames().stream().map(ScoreDetailDto::new).collect(Collectors.toList()));
        }
        if (scoreDtoIn.getGameWithAnother()){
            scoreDetailDtos.addAll(user.getMultiGames().stream().map(ScoreDetailDto::new).collect(Collectors.toList()));
        }

        return scoreDtoOut;
    }
}
