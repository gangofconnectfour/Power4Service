package com.gangofconnectfour.powerfourservice.api.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreDtoOut {

    private ScoreDetailDto scoreGame;
    private ScoreDetailDto scorePlayer;

}
