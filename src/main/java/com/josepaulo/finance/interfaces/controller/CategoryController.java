package com.josepaulo.finance.interfaces.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josepaulo.finance.application.useCases.category.CreateCategoryUseCase;
import com.josepaulo.finance.domain.entities.CategoryEntity;
import com.josepaulo.finance.interfaces.dto.CreateCategoryDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CreateCategoryUseCase createCategoryUseCase;

    @PostMapping
    public ResponseEntity<CategoryEntity> create(@RequestBody CreateCategoryDTO dto) {
        CategoryEntity category = createCategoryUseCase.execute(dto);
        return ResponseEntity.ok(category);
    }
}