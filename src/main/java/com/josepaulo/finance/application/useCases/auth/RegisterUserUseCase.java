package com.josepaulo.finance.application.useCases.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.josepaulo.finance.domain.entities.UserEntity;
import com.josepaulo.finance.domain.repositories.IUserRepository;
import com.josepaulo.finance.infra.security.JwtService;
import com.josepaulo.finance.interfaces.dto.auth.RegisterRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterUserUseCase {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String execute(RegisterRequestDTO request) {
        var user = UserEntity.builder()
                .name(request.getName())
                .whatsappNumber(request.getWhatsappNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);
        return jwtService.generateToken(user.getId());
    }
}
