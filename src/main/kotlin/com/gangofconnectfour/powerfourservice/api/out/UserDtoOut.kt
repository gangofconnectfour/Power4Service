package com.gangofconnectfour.powerfourservice.api.out

class UserDtoOut {

    var uuid : String = ""
    var nickname : String = ""
    var email : String = ""
    var level : Int = 0
    var score : Double = 0.toDouble()

    constructor()

    constructor(uuid: String, nickname: String, email: String) {
        this.uuid = uuid
        this.nickname = nickname
        this.email = email
    }

    constructor(uuid: String, nickname: String, email: String, level: Int, score: Double) {
        this.uuid = uuid
        this.nickname = nickname
        this.email = email
        this.level = level
        this.score = score
    }

}