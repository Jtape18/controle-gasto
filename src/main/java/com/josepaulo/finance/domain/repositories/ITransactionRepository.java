package com.josepaulo.finance.domain.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.josepaulo.finance.domain.entities.TransactionEntity;
import com.josepaulo.finance.domain.entities.UserEntity;

public interface ITransactionRepository {
    TransactionEntity save(TransactionEntity transaction);

    Optional<TransactionEntity> findById(UUID id);

    void delete(UUID id);

    List<TransactionEntity> findByUser(UserEntity user);

    List<TransactionEntity> findByUserAndDateBetween(UserEntity user, LocalDateTime start, LocalDateTime end);

}
