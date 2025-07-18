package com.josepaulo.finance.infra.database.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.josepaulo.finance.domain.entities.UserEntity;
import com.josepaulo.finance.domain.repositories.IUserRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements IUserRepository {

    private final UserJpaRepository jpaRepository;

    @Override
    public Optional<UserEntity> findByWhatsappNumber(String whatsappNumber) {
        return jpaRepository.findByWhatsappNumber(whatsappNumber);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return jpaRepository.save(user);
    }
}