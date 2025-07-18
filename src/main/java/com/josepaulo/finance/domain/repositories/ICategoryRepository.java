package com.josepaulo.finance.domain.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.josepaulo.finance.domain.entities.CategoryEntity;

public interface ICategoryRepository {
    Optional<CategoryEntity> findById(UUID id);

    CategoryEntity save(CategoryEntity category);

    Optional<CategoryEntity> findByName(String name);

    List<CategoryEntity> findAll();

    void delete(CategoryEntity category);

}
