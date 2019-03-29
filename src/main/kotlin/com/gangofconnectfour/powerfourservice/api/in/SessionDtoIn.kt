package com.gangofconnectfour.powerfourservice.api.`in`

import org.springframework.validation.annotation.Validated
import javax.validation.constraints.Email

@Validated
class SessionDtoIn {

    @Email
    var email : String = ""
    var encryptedPass : String = ""
    var nickname : String = ""
    var token : String = ""


    constructor()
    constructor(email: String, encryptedPass: String, nickname: String, token: String) {
        this.email = email
        this.encryptedPass = encryptedPass
        this.nickname = nickname
        this.token = token
    }


}