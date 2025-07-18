package com.josepaulo.finance.interfaces.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josepaulo.finance.application.useCases.transaction.CreateTransactionUseCase;
import com.josepaulo.finance.application.useCases.transaction.DeleteTransactionUseCase;
import com.josepaulo.finance.application.useCases.transaction.UpdateTransactionUseCase;
import com.josepaulo.finance.domain.entities.TransactionEntity;
import com.josepaulo.finance.interfaces.dto.CreateTransactionDTO;
import com.josepaulo.finance.interfaces.dto.UpdateTransactionDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final CreateTransactionUseCase createTransactionUseCase;
    private final UpdateTransactionUseCase updateTransactionUseCase;
    private final DeleteTransactionUseCase deleteTransactionUseCase;

    @PostMapping
    public ResponseEntity<TransactionEntity> create(@RequestBody CreateTransactionDTO dto) {
        TransactionEntity transaction = createTransactionUseCase.execute(dto);
        return ResponseEntity.ok(transaction);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TransactionEntity> update(
            @PathVariable UUID id,
            @RequestBody UpdateTransactionDTO dto) {
        TransactionEntity updated = updateTransactionUseCase.execute(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteTransactionUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
