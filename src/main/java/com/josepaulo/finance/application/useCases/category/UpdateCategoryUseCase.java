package com.josepaulo.finance.application.useCases.category;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.josepaulo.finance.domain.entities.CategoryEntity;
import com.josepaulo.finance.domain.repositories.ICategoryRepository;
import com.josepaulo.finance.interfaces.dto.UpdateCategoryDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateCategoryUseCase {

    private final ICategoryRepository categoryRepository;

    public CategoryEntity execute(UUID id, UpdateCategoryDTO dto) {
        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(dto.getName());

        return categoryRepository.save(category);
    }

}
