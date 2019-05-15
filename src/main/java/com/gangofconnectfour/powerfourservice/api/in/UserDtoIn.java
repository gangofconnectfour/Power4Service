package com.gangofconnectfour.powerfourservice.api.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

@Validated
@ApiModel(description = "Model pour creer et mettre a jour un utilisateur")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoIn {

    @Email
    @ApiModelProperty(notes = "Email de l'utilisateur")
    private String email;
    @ApiModelProperty(notes = "Mot de passe de l'utilisateur")
    private String password;
    @ApiModelProperty(notes = "Id de l'utilisateur")
    private Long uuid;
    @ApiModelProperty(notes = "Speudo de l'utilisateur")
    private String nickname;

}
