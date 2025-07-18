package com.josepaulo.finance.interfaces.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.josepaulo.finance.domain.enums.TransactionType;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateTransactionDTO {
    private String description;
    private BigDecimal value;
    private TransactionType type;
    private UUID userId;

    @NotNull(message = "Category ID is required")
    private UUID categoryId;
}
