package com.gangofconnectfour.powerfourservice.api.out;

import lombok.Data;

import java.util.List;

@Data
public class ScoreDtoOut {

    private ScoreDetailDto scoreGame;
    private List<ScoreDetailDto> scorePlayer;

}
