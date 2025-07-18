package com.josepaulo.finance.infra.database.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josepaulo.finance.domain.entities.TransactionEntity;

public interface JpaTransactionRepository extends JpaRepository<TransactionEntity, UUID> {
}
