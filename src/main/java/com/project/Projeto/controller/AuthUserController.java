package com.project.Projeto.controller;

import com.project.Projeto.dto.LoginDTO;
import com.project.Projeto.dto.RegisterDTO;
import com.project.Projeto.dto.TokenResponse;
import com.project.Projeto.exceptions.NotFoundException;
import com.project.Projeto.services.LoginService;
import com.project.Projeto.services.RegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthUserController {
    private final RegisterService registerService;
    private final LoginService loginService;

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegisterDTO registerDTO){
        registerService.register(registerDTO);
    }

    @PostMapping("/login")
    public TokenResponse login(@Valid @RequestBody LoginDTO loginDTO) throws NotFoundException {
        return loginService.login(loginDTO);
    }
}
