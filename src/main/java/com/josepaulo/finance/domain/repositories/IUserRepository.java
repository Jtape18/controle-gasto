package com.josepaulo.finance.domain.repositories;

import java.util.Optional;

import com.josepaulo.finance.domain.entities.UserEntity;

public interface IUserRepository {
    Optional<UserEntity> findByWhatsappNumber(String whatsappNumber);

    UserEntity save(UserEntity user);
}
