package com.gangofconnectfour.powerfourservice.api.out

class ScoreDtoOut {

    var scoreGame : ScoreDetailDto? = null
    var scorePlayer : ScoreDetailDto? = null

    constructor()


    constructor(scoreGame: ScoreDetailDto?, scorePlayer: ScoreDetailDto?) {
        this.scoreGame = scoreGame
        this.scorePlayer = scorePlayer
    }


}