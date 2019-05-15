package com.gangofconnectfour.powerfourservice.api.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionDtoOut {

    private String token;
    private Boolean isSigin = Boolean.FALSE;
}
