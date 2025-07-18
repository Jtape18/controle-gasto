package com.josepaulo.finance.application.useCases;

import org.springframework.stereotype.Service;

import com.josepaulo.finance.domain.entities.UserEntity;
import com.josepaulo.finance.domain.repositories.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final IUserRepository userRepository;

    public UserEntity execute(String name, String whatsappNumber) {
        return userRepository.save(UserEntity.builder()
                .name(name)
                .whatsappNumber(whatsappNumber)
                .build());
    }
}
