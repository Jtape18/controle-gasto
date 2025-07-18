package com.josepaulo.finance.interfaces.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.josepaulo.finance.application.useCases.report.GetCategorySummaryUseCase;
import com.josepaulo.finance.application.useCases.report.GetCurrentMonthSummaryUseCase;
import com.josepaulo.finance.interfaces.dto.CategorySummaryResponse;
import com.josepaulo.finance.interfaces.dto.CurrentMonthSummaryResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final GetCategorySummaryUseCase getCategorySummaryUseCase;
    private final GetCurrentMonthSummaryUseCase getCurrentMonthSummaryUseCase;

    @GetMapping("/category-summary")
    public List<CategorySummaryResponse> getCategorySummary(@RequestParam String whatsappNumber) {
        return getCategorySummaryUseCase.execute(whatsappNumber);
    }

    @GetMapping("/current-month")
    public CurrentMonthSummaryResponse getCurrentMonthSummary(@RequestParam String whatsappNumber) {
        return getCurrentMonthSummaryUseCase.execute(whatsappNumber);
    }

}
