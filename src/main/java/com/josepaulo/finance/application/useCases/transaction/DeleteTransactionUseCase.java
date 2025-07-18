package com.josepaulo.finance.application.useCases.transaction;

import com.josepaulo.finance.domain.repositories.ITransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteTransactionUseCase {

    private final ITransactionRepository transactionRepository;

    public void execute(UUID id) {
        transactionRepository.delete(id);
    }
}
