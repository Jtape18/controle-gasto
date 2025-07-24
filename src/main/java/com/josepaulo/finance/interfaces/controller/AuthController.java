package com.josepaulo.finance.interfaces.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josepaulo.finance.application.useCases.auth.LoginUserUseCase;
import com.josepaulo.finance.application.useCases.auth.RegisterUserUseCase;
import com.josepaulo.finance.interfaces.dto.auth.AuthResponseDTO;
import com.josepaulo.finance.interfaces.dto.auth.LoginRequestDTO;
import com.josepaulo.finance.interfaces.dto.auth.RegisterRequestDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final RegisterUserUseCase registerUserUseCase;
    private final LoginUserUseCase loginUserUseCase;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody @Valid RegisterRequestDTO request) {
        String token = registerUserUseCase.execute(request);
        return ResponseEntity.ok(new AuthResponseDTO(token));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody @Valid LoginRequestDTO request) {
        String token = loginUserUseCase.execute(request);
        return ResponseEntity.ok(new AuthResponseDTO(token));
    }
}
