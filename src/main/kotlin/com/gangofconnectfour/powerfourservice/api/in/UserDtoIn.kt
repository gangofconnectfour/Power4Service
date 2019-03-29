package com.gangofconnectfour.powerfourservice.api.`in`


import org.springframework.validation.annotation.Validated
import javax.validation.constraints.Email

@Validated
class UserDtoIn {

    @Email
    var email : String = ""
    var encryptedPass : String = ""
    var uuid : String = ""
    var token : String = ""
    var nickname : String = ""


    constructor()

}