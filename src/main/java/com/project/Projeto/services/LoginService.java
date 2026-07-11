package com.project.Projeto.services;

import com.project.Projeto.config.TokenProvider;
import com.project.Projeto.database.model.UsuariosEntity;
import com.project.Projeto.database.repository.UsuarioRepository;
import com.project.Projeto.dto.LoginDTO;
import com.project.Projeto.dto.TokenResponse;
import com.project.Projeto.dto.UsuariosDTO;
import com.project.Projeto.exceptions.BadRequestException;
import com.project.Projeto.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    @Value("${jwt.expiration}")
    private long expiration;

    public TokenResponse login(LoginDTO loginDTO) throws NotFoundException {
        try {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getSenha()));
            String token = tokenProvider.gerarToken(auth);
            return new TokenResponse(token, expiration);
        }catch (BadCredentialsException e){
            new BadRequestException("Credenciais Inválidas");
        } catch (Exception e){
            throw e;
        }
        return null;
    }
}

