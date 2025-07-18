package com.josepaulo.finance.application.useCases.transaction;

import java.util.List;

import org.springframework.stereotype.Service;

import com.josepaulo.finance.domain.entities.TransactionEntity;
import com.josepaulo.finance.domain.entities.UserEntity;
import com.josepaulo.finance.domain.repositories.ITransactionRepository;
import com.josepaulo.finance.domain.repositories.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetAllTransactionsUseCase {

    private final IUserRepository userRepository;
    private final ITransactionRepository transactionRepository;

    public List<TransactionEntity> execute(String whatsappNumber) {
        UserEntity user = userRepository.findByWhatsappNumber(whatsappNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return transactionRepository.findByUser(user);
    }
}