package com.josepaulo.finance.application.useCases.report;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.josepaulo.finance.domain.entities.TransactionEntity;
import com.josepaulo.finance.domain.entities.UserEntity;
import com.josepaulo.finance.domain.enums.TransactionType;
import com.josepaulo.finance.domain.repositories.ITransactionRepository;
import com.josepaulo.finance.domain.repositories.IUserRepository;
import com.josepaulo.finance.interfaces.dto.PeriodReportResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetPeriodReportUseCase {

    private final IUserRepository userRepository;
    private final ITransactionRepository transactionRepository;

    public PeriodReportResponse execute(String whatsappNumber, LocalDateTime start, LocalDateTime end) {
        UserEntity user = userRepository.findByWhatsappNumber(whatsappNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<TransactionEntity> transactions = transactionRepository.findByUserAndDateBetween(user, start, end);

        BigDecimal income = transactions.stream()
                .filter(t -> t.getType() == TransactionType.INCOME)
                .map(TransactionEntity::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal expense = transactions.stream()
                .filter(t -> t.getType() == TransactionType.EXPENSE)
                .map(TransactionEntity::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal balance = income.subtract(expense);

        return new PeriodReportResponse(income, expense, balance);
    }
}
