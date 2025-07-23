package com.josepaulo.finance.interfaces.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.josepaulo.finance.domain.enums.TransactionType;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Data Transfer Object for creating a new transaction")
public class CreateTransactionDTO {

    @Schema(description = "Transaction description", example = "Grocery shopping")
    private String description;
    @Schema(description = "Transaction value", example = "150.75")
    private BigDecimal value;
    @Schema(description = "Transaction type", example = "EXPENSE")
    private TransactionType type;
    @Schema(description = "User ID (UUID)", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID userId;

    @Schema(description = "Category ID (UUID)", example = "223e4567-e89b-12d3-a456-426614174999")
    @NotNull(message = "Category ID is required")
    private UUID categoryId;
}
