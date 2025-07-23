package com.josepaulo.finance.interfaces.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Data Transfer Object for creating a new category")
public class CreateCategoryDTO {
    @Schema(description = "Category name", example = "Groceries")
    private String name;

}
