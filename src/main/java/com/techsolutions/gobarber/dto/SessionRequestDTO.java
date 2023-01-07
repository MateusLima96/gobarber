package com.techsolutions.gobarber.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionRequestDTO {

    private String email;
    private String password;
}
