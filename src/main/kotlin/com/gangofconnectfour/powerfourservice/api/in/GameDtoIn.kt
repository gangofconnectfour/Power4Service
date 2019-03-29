package com.gangofconnectfour.powerfourservice.api.`in`

class GameDtoIn {

    var token : String = ""
    var uuid : String = ""
    var aiDifficulty : Int = 0
    var versusAi : Boolean = false

    constructor()
    constructor(token: String, uuid: String, aiDifficulty: Int, versusAi: Boolean) {
        this.token = token
        this.uuid = uuid
        this.aiDifficulty = aiDifficulty
        this.versusAi = versusAi
    }


}