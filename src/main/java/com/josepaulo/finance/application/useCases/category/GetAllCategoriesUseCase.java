package com.josepaulo.finance.application.useCases.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.josepaulo.finance.domain.entities.CategoryEntity;
import com.josepaulo.finance.domain.repositories.ICategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetAllCategoriesUseCase {

    private final ICategoryRepository categoryRepository;

    public List<CategoryEntity> execute() {
        return categoryRepository.findAll();
    }
}
