package com.josepaulo.finance.interfaces.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josepaulo.finance.application.useCases.category.CreateCategoryUseCase;
import com.josepaulo.finance.application.useCases.category.GetAllCategoriesUseCase;
import com.josepaulo.finance.domain.entities.CategoryEntity;
import com.josepaulo.finance.interfaces.dto.CreateCategoryDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CreateCategoryUseCase createCategoryUseCase;
    private final GetAllCategoriesUseCase getAllCategoriesUseCase;

    @PostMapping
    public ResponseEntity<CategoryEntity> create(@RequestBody CreateCategoryDTO dto) {
        CategoryEntity category = createCategoryUseCase.execute(dto);
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<List<CategoryEntity>> getAllCategories() {
        var result = getAllCategoriesUseCase.execute();
        return ResponseEntity.ok(result);
    }
}