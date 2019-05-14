package com.gangofconnectfour.powerfourservice.api.`in`

import javax.validation.constraints.Email

class LoginDtoIn {

    @Email
    var mail : String? = null;
    var password : String? = null;
}