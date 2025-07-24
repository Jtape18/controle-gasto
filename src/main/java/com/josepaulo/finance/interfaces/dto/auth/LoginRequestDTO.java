package com.josepaulo.finance.interfaces.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {

    @NotBlank
    private String whatsappNumber;

    @NotBlank
    private String password;
}
