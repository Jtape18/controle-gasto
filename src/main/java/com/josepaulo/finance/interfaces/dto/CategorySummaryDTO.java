package com.josepaulo.finance.interfaces.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Data Transfer Object for category summary")
public class CategorySummaryDTO {
    @Schema(description = "Name of the category", example = "Groceries")
    private String category;
    @Schema(description = "Total amount spent in the category", example = "150.00")
    private Double total;
}
