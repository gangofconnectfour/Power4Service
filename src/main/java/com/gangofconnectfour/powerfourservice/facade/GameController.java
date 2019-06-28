package com.gangofconnectfour.powerfourservice.facade;

import com.gangofconnectfour.powerfourservice.api.in.GameDtoIn;
import com.gangofconnectfour.powerfourservice.api.out.GameDtoOut;
import com.gangofconnectfour.powerfourservice.model.MultiGame;
import com.gangofconnectfour.powerfourservice.model.SoloGame;
import com.gangofconnectfour.powerfourservice.repository.impl.MultiGameService;
import com.gangofconnectfour.powerfourservice.repository.impl.SoloGameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private MultiGameService multiGameService;
    private SoloGameService soloGameService;

    public GameController(MultiGameService multiGameService, SoloGameService soloGameService) {
        this.multiGameService = multiGameService;
        this.soloGameService = soloGameService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GameDtoOut> createGame(@RequestBody GameDtoIn dtoIn, UriComponentsBuilder uriBuilder) {
        Long uuid = null;
        if (dtoIn.getVersusAi()){
            uuid = soloGameService.save(new SoloGame(dtoIn)).getUuid();
        } else {
            uuid = multiGameService.save(new MultiGame(dtoIn)).getUuid();
        }
        URI uri = uriBuilder.path("/api/games/{uuid}/details?versusAi="+dtoIn.getVersusAi()).buildAndExpand(uuid).toUri();
        return created(uri).build();
    }

    @GetMapping("/{uuid}/details")
    public GameDtoOut getGame(@RequestBody GameDtoIn dtoIn) {
        GameDtoOut gameDtoOut = null;
        if (dtoIn.getVersusAi()){
            SoloGame soloGame = soloGameService.findById(dtoIn.getId());
            gameDtoOut = new GameDtoOut(soloGame);
        } else {
            MultiGame multiGame = multiGameService.findById(dtoIn.getId());
            gameDtoOut = new GameDtoOut(multiGame);
        }
        return gameDtoOut;
    }

    @GetMapping
    public List<GameDtoOut> getGames() {
        List<GameDtoOut> gameDtoOuts = new ArrayList<>();
            gameDtoOuts.addAll(soloGameService.findAll().stream().map(GameDtoOut::new).collect(Collectors.toList()));
            gameDtoOuts.addAll(multiGameService.findAll().stream().map(GameDtoOut::new).collect(Collectors.toList()));
        return gameDtoOuts;
    }

}
