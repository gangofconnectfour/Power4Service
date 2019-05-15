package com.gangofconnectfour.powerfourservice.api.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDtoIn {

    private String token;
    private Long uuid;
    private int aiDifficulty = 0;
    private Boolean versusAi = Boolean.FALSE;
}
