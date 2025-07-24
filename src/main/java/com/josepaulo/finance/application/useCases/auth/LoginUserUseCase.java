package com.josepaulo.finance.application.useCases.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.josepaulo.finance.domain.repositories.IUserRepository;
import com.josepaulo.finance.infra.security.JwtService;
import com.josepaulo.finance.interfaces.dto.auth.LoginRequestDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Schema(description = "Use case for logging in a user")
public class LoginUserUseCase {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String execute(LoginRequestDTO request) {
        var user = userRepository.findByWhatsappNumber(request.getWhatsappNumber())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Credenciais inválidas");
        }

        return jwtService.generateToken(user.getId());
    }
}
