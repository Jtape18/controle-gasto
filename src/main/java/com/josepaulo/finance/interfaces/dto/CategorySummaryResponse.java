package com.josepaulo.finance.interfaces.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Response DTO for category summary")
public class CategorySummaryResponse {
    @Schema(description = "Name of the category", example = "Groceries")
    private String categoryName;
    @Schema(description = "Total amount spent in the category", example = "150.00")
    private Double total;
}
