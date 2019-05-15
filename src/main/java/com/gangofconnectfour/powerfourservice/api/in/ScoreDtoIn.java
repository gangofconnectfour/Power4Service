package com.gangofconnectfour.powerfourservice.api.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDtoIn {

    private String token;
    private Long uuidUser;
    private Long  uuidGame;
    private Boolean isScorePlayer = Boolean.FALSE;
    private Boolean isScoreGame = Boolean.FALSE;

}
