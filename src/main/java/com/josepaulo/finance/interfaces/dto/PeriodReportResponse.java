package com.josepaulo.finance.interfaces.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Response DTO for period report")
public class PeriodReportResponse {
    @Schema(description = "Total income for the period", example = "5000.00")
    private BigDecimal income;
    @Schema(description = "Total expense for the period", example = "3000.00")
    private BigDecimal expense;
    @Schema(description = "Balance for the period", example = "2000.00")
    private BigDecimal balance;
}
