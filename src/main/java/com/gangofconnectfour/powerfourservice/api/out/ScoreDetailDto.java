package com.gangofconnectfour.powerfourservice.api.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreDetailDto {

    private Long uuid;
    private Long duration = 0L;
    private int nbTurn = 0;
    private Long winnerId;
}
