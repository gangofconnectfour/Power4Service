package com.gangofconnectfour.powerfourservice.api.out;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gangofconnectfour.powerfourservice.model.MultiGame;
import com.gangofconnectfour.powerfourservice.model.SoloGame;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDtoOut {

    private Long id;
    private Integer aiDificulty;
    private Boolean versusAi;
    private Long duration;
    private Integer nbTurn;
    private Long winnerId;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm")
    private LocalDateTime createdAt;

    public GameDtoOut(SoloGame soloGame) {
        this.id = soloGame.getUuid();
        this.versusAi = Boolean.TRUE;
        this.aiDificulty = soloGame.getAiDificulty();
        this.duration = soloGame.getScoreLogger().getDuration();
        this.nbTurn = soloGame.getScoreLogger().getNbTurn();
        this.winnerId = soloGame.getScoreLogger().getWinnerId();
        this.createdAt = soloGame.getGame().getCreatedAt();
    }

    public GameDtoOut(MultiGame multiGame) {
        this.id = multiGame.getUuid();
        this.versusAi = Boolean.FALSE;
        this.duration = multiGame.getScoreLogger().getDuration();
        this.nbTurn = multiGame.getScoreLogger().getNbTurn();
        this.winnerId = multiGame.getScoreLogger().getWinnerId();
        this.createdAt = multiGame.getGame().getCreatedAt();
    }
}
