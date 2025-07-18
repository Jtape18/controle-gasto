package com.josepaulo.finance.application.useCases.report;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.josepaulo.finance.domain.entities.TransactionEntity;
import com.josepaulo.finance.domain.entities.UserEntity;
import com.josepaulo.finance.domain.repositories.ITransactionRepository;
import com.josepaulo.finance.domain.repositories.IUserRepository;
import com.josepaulo.finance.interfaces.dto.CategorySummaryResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetCategorySummaryUseCase {

        private final IUserRepository userRepository;
        private final ITransactionRepository transactionRepository;

        public List<CategorySummaryResponse> execute(String whatsappNumber) {
                UserEntity user = userRepository.findByWhatsappNumber(whatsappNumber)
                                .orElseThrow(() -> new RuntimeException("User not found"));

                YearMonth currentMonth = YearMonth.now();
                LocalDateTime startOfMonth = currentMonth.atDay(1).atStartOfDay();
                LocalDateTime endOfMonth = currentMonth.atEndOfMonth().atTime(23, 59, 59);

                List<TransactionEntity> transactions = transactionRepository.findByUserAndDateBetween(
                                user, startOfMonth, endOfMonth);

                Map<String, Double> grouped = transactions.stream()
                                .filter(t -> t.getCategory() != null)
                                .collect(Collectors.groupingBy(
                                                t -> t.getCategory().getName(),
                                                Collectors.summingDouble(t -> t.getValue().doubleValue())));

                return grouped.entrySet().stream()
                                .map(entry -> new CategorySummaryResponse(entry.getKey(), entry.getValue()))
                                .toList();
        }
}
