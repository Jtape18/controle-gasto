package com.josepaulo.finance.interfaces.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Data;

@Data
public class UpdateTransactionDTO {
    private String description;
    private BigDecimal value;
    private String type;
    private UUID categoryId;

}
