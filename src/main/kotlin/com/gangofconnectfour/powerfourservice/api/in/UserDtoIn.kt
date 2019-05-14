package com.gangofconnectfour.powerfourservice.api.`in`


import org.springframework.validation.annotation.Validated
import javax.validation.constraints.Email

@Validated
class UserDtoIn {

    @Email
    var email : String? = null
    var encryptedPass : String? = null
    var uuid : String? = null
    var nickname : String? = null

    constructor()

}