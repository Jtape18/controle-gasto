package com.josepaulo.finance.interfaces.dto;

import java.math.BigDecimal;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO for updating a transaction")
public class UpdateTransactionDTO {
    @Schema(description = "Description of the transaction", example = "Grocery shopping")
    private String description;
    @Schema(description = "Value of the transaction", example = "150.00")
    private BigDecimal value;
    @Schema(description = "Type of the transaction", example = "EXPENSE")
    private String type;
    @Schema(description = "Category ID of the transaction")
    private UUID categoryId;

}
