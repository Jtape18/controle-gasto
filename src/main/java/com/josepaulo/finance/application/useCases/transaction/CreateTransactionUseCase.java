
package com.josepaulo.finance.application.useCases.transaction;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.josepaulo.finance.domain.entities.CategoryEntity;
import com.josepaulo.finance.domain.entities.TransactionEntity;
import com.josepaulo.finance.domain.entities.UserEntity;
import com.josepaulo.finance.domain.repositories.ICategoryRepository;
import com.josepaulo.finance.domain.repositories.ITransactionRepository;
import com.josepaulo.finance.domain.repositories.IUserRepository;
import com.josepaulo.finance.interfaces.dto.CreateTransactionDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateTransactionUseCase {

    private final ITransactionRepository transactionRepository;
    private final IUserRepository userRepository;
    private final ICategoryRepository categoryRepository;

    public TransactionEntity execute(CreateTransactionDTO dto) {
        UserEntity user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        CategoryEntity category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        TransactionEntity transaction = TransactionEntity.builder()
                .description(dto.getDescription())
                .value(dto.getValue())
                .type(dto.getType())
                .user(user)
                .category(category)
                .date(LocalDateTime.now())
                .build();

        return transactionRepository.save(transaction);
    }
}
