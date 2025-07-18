package com.josepaulo.finance.infra.database.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.josepaulo.finance.domain.entities.CategoryEntity;
import com.josepaulo.finance.domain.repositories.ICategoryRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements ICategoryRepository {

    private final CategoryJpaRepository jpaRepository;

    @Override
    public Optional<CategoryEntity> findById(UUID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public CategoryEntity save(CategoryEntity category) {
        return jpaRepository.save(category);
    }

    @Override
    public Optional<CategoryEntity> findByName(String name) {
        return jpaRepository.findByName(name);
    }

    @Override
    public List<CategoryEntity> findAll() {
        return jpaRepository.findAll();
    }
}
