package com.josepaulo.finance.interfaces.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Request DTO for user login")
public class LoginRequestDTO {

    @NotBlank
    @Schema(description = "User's WhatsApp number", example = "+5511999998888")
    private String whatsappNumber;

    @NotBlank
    @Schema(description = "User's password", example = "password123")
    private String password;
}
