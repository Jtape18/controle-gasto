package com.josepaulo.finance.application.useCases.report;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

import org.springframework.stereotype.Service;

import com.josepaulo.finance.domain.entities.TransactionEntity;
import com.josepaulo.finance.domain.entities.UserEntity;
import com.josepaulo.finance.domain.enums.TransactionType;
import com.josepaulo.finance.domain.repositories.ITransactionRepository;
import com.josepaulo.finance.domain.repositories.IUserRepository;
import com.josepaulo.finance.interfaces.dto.CurrentMonthSummaryResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetCurrentMonthSummaryUseCase {

    private final IUserRepository userRepository;
    private final ITransactionRepository transactionRepository;

    public CurrentMonthSummaryResponse execute(String whatsappNumber) {
        UserEntity user = userRepository.findByWhatsappNumber(whatsappNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));

        YearMonth currentMonth = YearMonth.now();
        LocalDateTime start = currentMonth.atDay(1).atStartOfDay();
        LocalDateTime end = currentMonth.atEndOfMonth().atTime(23, 59, 59);

        List<TransactionEntity> transactions = transactionRepository.findByUserAndDateBetween(user, start, end);

        double totalIncome = transactions.stream()
                .filter(t -> t.getType() == TransactionType.INCOME)
                .mapToDouble(t -> t.getValue().doubleValue())
                .sum();

        double totalExpense = transactions.stream()
                .filter(t -> t.getType() == TransactionType.EXPENSE)
                .mapToDouble(t -> t.getValue().doubleValue())
                .sum();

        return new CurrentMonthSummaryResponse(totalIncome, totalExpense, totalIncome - totalExpense);
    }
}
