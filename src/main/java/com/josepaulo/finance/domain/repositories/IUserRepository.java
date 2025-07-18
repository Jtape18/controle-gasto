package com.josepaulo.finance.domain.repositories;

import java.util.Optional;
import java.util.UUID;

import com.josepaulo.finance.domain.entities.UserEntity;

public interface IUserRepository {
    Optional<UserEntity> findByWhatsappNumber(String whatsappNumber);

    Optional<UserEntity> findById(UUID id);

    UserEntity save(UserEntity user);
}
