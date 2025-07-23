package com.josepaulo.finance.interfaces.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Data Transfer Object for creating a new user")
public class CreateUserDTO {
    @Schema(description = "User name", example = "John Doe")
    private String name;
    @Schema(description = "User WhatsApp number", example = "+1234567890")
    private String whatsappNumber;
}
