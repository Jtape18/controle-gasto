package com.josepaulo.finance.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrentMonthSummaryResponse {
    private double totalIncome;
    private double totalExpense;
    private double balance;
}
