package com.josepaulo.finance.interfaces.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josepaulo.finance.application.useCases.category.CreateCategoryUseCase;
import com.josepaulo.finance.application.useCases.category.DeleteCategoryUseCase;
import com.josepaulo.finance.application.useCases.category.GetAllCategoriesUseCase;
import com.josepaulo.finance.application.useCases.category.GetCategoryByIdUseCase;
import com.josepaulo.finance.application.useCases.category.UpdateCategoryUseCase;
import com.josepaulo.finance.domain.entities.CategoryEntity;
import com.josepaulo.finance.interfaces.dto.CreateCategoryDTO;
import com.josepaulo.finance.interfaces.dto.UpdateCategoryDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CreateCategoryUseCase createCategoryUseCase;
    private final GetAllCategoriesUseCase getAllCategoriesUseCase;
    private final GetCategoryByIdUseCase getCategoryByIdUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;
    private final DeleteCategoryUseCase deleteCategoryUseCase;

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

    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> getById(@PathVariable UUID id) {
        CategoryEntity category = getCategoryByIdUseCase.execute(id);
        return ResponseEntity.ok(category);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryEntity> update(@PathVariable UUID id, @RequestBody UpdateCategoryDTO dto) {
        CategoryEntity updated = updateCategoryUseCase.execute(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteCategoryUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

}