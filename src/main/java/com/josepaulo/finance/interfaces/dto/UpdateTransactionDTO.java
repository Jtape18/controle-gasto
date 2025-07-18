package com.josepaulo.finance.interfaces.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class UpdateTransactionDTO {
    private String description;
    private BigDecimal value;
    private String type; // "INCOME" ou "EXPENSE"
}
