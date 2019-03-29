package com.gangofconnectfour.powerfourservice.api.out

class ScoreDetailDto {

    var uuid: String = ""
    var duration: Long = 0L
    var nbTurn: Int = 0
    var winnerId: String = ""

    constructor()

    constructor(uuid: String, duration: Long, nbTurn: Int, winnerId: String) {
        this.uuid = uuid
        this.duration = duration
        this.nbTurn = nbTurn
        this.winnerId = winnerId
    }


}
