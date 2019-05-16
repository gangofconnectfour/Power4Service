package com.gangofconnectfour.powerfourservice.api.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDtoIn {

    @Email
    private String email;
    private String encryptedPass;
    private String nickname;
    private String token;
}
