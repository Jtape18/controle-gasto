package com.josepaulo.finance.application.useCases.category;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.josepaulo.finance.domain.entities.CategoryEntity;
import com.josepaulo.finance.domain.repositories.ICategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetCategoryByIdUseCase {

    private final ICategoryRepository categoryRepository;

    public CategoryEntity execute(UUID id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }
}