package com.josepaulo.finance.interfaces.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.josepaulo.finance.application.useCases.report.GetCategorySummaryUseCase;
import com.josepaulo.finance.application.useCases.report.GetCurrentMonthSummaryUseCase;
import com.josepaulo.finance.application.useCases.report.GetPeriodReportUseCase;
import com.josepaulo.finance.interfaces.dto.CategorySummaryResponse;
import com.josepaulo.finance.interfaces.dto.CurrentMonthSummaryResponse;
import com.josepaulo.finance.interfaces.dto.PeriodReportResponse;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
@Tag(name = "Reports", description = "Endpoints for generating financial reports")
@SecurityRequirement(name = "Bearer Authentication")
public class ReportController {

    private final GetCategorySummaryUseCase getCategorySummaryUseCase;
    private final GetCurrentMonthSummaryUseCase getCurrentMonthSummaryUseCase;
    private final GetPeriodReportUseCase getPeriodReportUseCase;

    @GetMapping("/category-summary")
    public List<CategorySummaryResponse> getCategorySummary(@RequestParam String whatsappNumber) {
        return getCategorySummaryUseCase.execute(whatsappNumber);
    }

    @GetMapping("/current-month")
    public CurrentMonthSummaryResponse getCurrentMonthSummary(@RequestParam String whatsappNumber) {
        return getCurrentMonthSummaryUseCase.execute(whatsappNumber);
    }

    @GetMapping("/period")
    public ResponseEntity<PeriodReportResponse> getPeriodReport(
            @RequestParam String whatsappNumber,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atTime(23, 59, 59);

        PeriodReportResponse response = getPeriodReportUseCase.execute(whatsappNumber, start, end);
        return ResponseEntity.ok(response);
    }

}
