package com.josepaulo.finance.interfaces.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josepaulo.finance.application.useCases.CreateTransactionUseCase;
import com.josepaulo.finance.domain.entities.TransactionEntity;
import com.josepaulo.finance.interfaces.dto.CreateTransactionDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final CreateTransactionUseCase createTransactionUseCase;

    @PostMapping
    public ResponseEntity<TransactionEntity> create(@RequestBody CreateTransactionDTO dto) {
        TransactionEntity transaction = createTransactionUseCase.execute(dto);
        return ResponseEntity.ok(transaction);
    }
}
