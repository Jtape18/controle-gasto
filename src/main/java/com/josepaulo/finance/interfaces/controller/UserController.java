package com.josepaulo.finance.interfaces.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josepaulo.finance.application.useCases.CreateUserUseCase;
import com.josepaulo.finance.domain.entities.UserEntity;
import com.josepaulo.finance.interfaces.dto.CreateUserDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "Users", description = "Endpoints for managing users")
@SecurityRequirement(name = "Bearer Authentication")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    public ResponseEntity<UserEntity> create(@RequestBody CreateUserDTO dto) {
        return ResponseEntity.ok(createUserUseCase.execute(dto.getName(), dto.getWhatsappNumber()));
    }

}
