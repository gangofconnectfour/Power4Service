package com.gangofconnectfour.powerfourservice.api.`in`


class ScoreDtoIn {
    var token : String = ""
    var uuidUser : String = ""
    var uuidGame : String = ""
    var isScorePlayer : Boolean = false
    var isScoreGame : Boolean = false;

    constructor(token: String, uuidUser: String, uuidGame: String, isScorePlayer: Boolean, isScoreGame: Boolean) {
        this.token = token
        this.uuidUser = uuidUser
        this.uuidGame = uuidGame
        this.isScorePlayer = isScorePlayer
        this.isScoreGame = isScoreGame
    }

    constructor()


}