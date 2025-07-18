package com.josepaulo.finance.interfaces.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PeriodReportResponse {
    private BigDecimal income;
    private BigDecimal expense;
    private BigDecimal balance;
}
