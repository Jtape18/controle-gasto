package com.josepaulo.finance.application.useCases.category;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.josepaulo.finance.domain.entities.CategoryEntity;
import com.josepaulo.finance.domain.repositories.ICategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteCategoryUseCase {

    private final ICategoryRepository categoryRepository;

    public void execute(UUID id) {
        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        categoryRepository.delete(category);
    }

}
