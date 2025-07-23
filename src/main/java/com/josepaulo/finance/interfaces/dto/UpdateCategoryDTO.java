package com.josepaulo.finance.interfaces.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO for updating a category")
public class UpdateCategoryDTO {
    @Schema(description = "New name for the category", example = "Groceries")
    private String name;
}
