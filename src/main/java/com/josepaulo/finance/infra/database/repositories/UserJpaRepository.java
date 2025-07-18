package com.josepaulo.finance.infra.database.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.josepaulo.finance.domain.entities.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByWhatsappNumber(String whatsappNumber);
}
