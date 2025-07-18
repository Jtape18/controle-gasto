package com.josepaulo.finance.application.useCases.transaction;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.josepaulo.finance.domain.entities.TransactionEntity;
import com.josepaulo.finance.domain.enums.TransactionType;
import com.josepaulo.finance.domain.repositories.ICategoryRepository;
import com.josepaulo.finance.domain.repositories.ITransactionRepository;
import com.josepaulo.finance.interfaces.dto.UpdateTransactionDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateTransactionUseCase {

    private final ITransactionRepository transactionRepository;
    private final ICategoryRepository categoryRepository;

    public TransactionEntity execute(UUID id, UpdateTransactionDTO dto) {
        TransactionEntity transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        if (dto.getDescription() != null) {
            transaction.setDescription(dto.getDescription());
        }

        if (dto.getValue() != null) {
            transaction.setValue(dto.getValue());
        }

        if (dto.getType() != null) {
            transaction.setType(TransactionType.valueOf(dto.getType()));
        }
        if (dto.getCategoryId() != null) {
            transaction.setCategory(
                    categoryRepository.findById(dto.getCategoryId())
                            .orElseThrow(() -> new RuntimeException("Category not found")));
        }

        return transactionRepository.save(transaction);
    }
}
