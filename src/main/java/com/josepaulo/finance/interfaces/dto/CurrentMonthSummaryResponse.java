package com.josepaulo.finance.interfaces.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Response DTO for the current month's financial summary")
public class CurrentMonthSummaryResponse {
    @Schema(description = "Total income for the current month", example = "5000.00")
    private double totalIncome;
    @Schema(description = "Total expense for the current month", example = "3000.00")
    private double totalExpense;
    @Schema(description = "Balance for the current month", example = "2000.00")
    private double balance;
}
