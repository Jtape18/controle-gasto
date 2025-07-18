package com.josepaulo.finance.infra.database.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.josepaulo.finance.domain.entities.TransactionEntity;
import com.josepaulo.finance.domain.repositories.ITransactionRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TransactionRepositoryImpl implements ITransactionRepository {

    private final JpaTransactionRepository jpaRepository;

    @Override
    public TransactionEntity save(TransactionEntity transaction) {
        return jpaRepository.save(transaction);
    }

    @Override
    public Optional<TransactionEntity> findById(UUID id) {
        return jpaRepository.findById(id);
    }
}
