package com.josepaulo.finance.interfaces.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String whatsappNumber;

    @NotBlank
    private String password;

}
