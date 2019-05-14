package com.gangofconnectfour.powerfourservice.api.`in`


import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.Email

@Validated
@ApiModel(description = "Model pour creer et mettre a jour un utilisateur")
class UserDtoIn {

    @Email
    @ApiModelProperty(notes = "Email de l'utilisateur")
    var email : String? = null
    @ApiModelProperty(notes = "Mot de passe de l'utilisateur")
    var password : String? = null
    @ApiModelProperty(notes = "Id de l'utilisateur")
    var uuid : Long? = null
    @ApiModelProperty(notes = "Speudo de l'utilisateur")
    var nickname : String? = null

}