package com.gangofconnectfour.powerfourservice.api.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class LoginDtoIn {

    @Email
    private String mail;
    private String password;
}
