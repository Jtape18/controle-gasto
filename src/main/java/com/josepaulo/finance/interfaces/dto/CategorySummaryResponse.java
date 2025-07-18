package com.josepaulo.finance.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategorySummaryResponse {
    private String categoryName;
    private Double total;
}
