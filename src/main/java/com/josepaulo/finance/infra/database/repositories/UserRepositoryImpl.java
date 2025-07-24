package com.josepaulo.finance.infra.database.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.josepaulo.finance.domain.entities.UserEntity;
import com.josepaulo.finance.domain.repositories.IUserRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements IUserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserEntity save(UserEntity user) {
        return userJpaRepository.saveAndFlush(user);

    }

    @Override
    public Optional<UserEntity> findByWhatsappNumber(String whatsappNumber) {
        return userJpaRepository.findByWhatsappNumber(whatsappNumber);
    }

    @Override
    public Optional<UserEntity> findById(UUID id) {
        return userJpaRepository.findById(id);
    }
}