package com.project.Projeto.services;

import com.project.Projeto.database.model.RolesEntity;
import com.project.Projeto.database.model.UsuariosEntity;
import com.project.Projeto.database.model.enums.RolesType;
import com.project.Projeto.database.repository.RolesRepository;
import com.project.Projeto.database.repository.UsuarioRepository;
import com.project.Projeto.dto.RegisterDTO;
import com.project.Projeto.dto.UsuariosDTO;
import com.project.Projeto.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RegisterService {
    private final RolesRepository rolesRepository;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(RegisterDTO registerDTO){
        UsuariosEntity usuarios = usuarioRepository.findByEmail(registerDTO.getEmail()).orElse(null);

        if (usuarios != null){
            new BadRequestException("Usuário já cadastrrado");
        }

        RolesEntity rolesEntity = rolesRepository.findByRoles(RolesType.USUARIO.name()).orElseGet(() -> rolesRepository.save(RolesEntity.builder()
                        .roles(RolesType.USUARIO.name())
                .build()));

        UsuariosEntity usuariosEntity = UsuariosEntity.builder()
                .nome(registerDTO.getNome())
                .idade(registerDTO.getIdade())
                .telefone(registerDTO.getTelefone())
                .email(registerDTO.getEmail())
                .rolesEntities(Set.of(rolesEntity))
                .senha(passwordEncoder.encode(registerDTO.getSenha()))
                .build();

        usuarioRepository.save(usuariosEntity);
    }
}
