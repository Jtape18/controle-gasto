package com.josepaulo.finance.application.useCases.category;

import org.springframework.stereotype.Service;

import com.josepaulo.finance.domain.entities.CategoryEntity;
import com.josepaulo.finance.domain.repositories.ICategoryRepository;
import com.josepaulo.finance.interfaces.dto.CreateCategoryDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateCategoryUseCase {

    private final ICategoryRepository categoryRepository;

    public CategoryEntity execute(CreateCategoryDTO dto) {
        categoryRepository.findByName(dto.getName()).ifPresent(c -> {
            throw new RuntimeException("Category already exists");
        });

        CategoryEntity category = CategoryEntity.builder()
                .name(dto.getName())
                .build();

        return categoryRepository.save(category);
    }
}
