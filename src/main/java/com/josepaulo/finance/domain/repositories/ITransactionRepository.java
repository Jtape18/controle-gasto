package com.josepaulo.finance.domain.repositories;

import java.util.Optional;
import java.util.UUID;

import com.josepaulo.finance.domain.entities.TransactionEntity;

public interface ITransactionRepository {
    TransactionEntity save(TransactionEntity transaction);

    Optional<TransactionEntity> findById(UUID id);
}
