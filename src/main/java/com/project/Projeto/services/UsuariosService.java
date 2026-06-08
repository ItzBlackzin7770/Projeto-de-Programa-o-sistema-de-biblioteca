package com.project.Projeto.services;

import com.project.Projeto.database.model.UsuariosEntity;
import com.project.Projeto.database.repository.UsuarioRepository;
import com.project.Projeto.dto.UsuariosDTO;
import com.project.Projeto.exceptions.NotFoundException;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuariosService {
    private final UsuarioRepository usuarioRepository;

    public List<UsuariosEntity> findAll(){
        return usuarioRepository.findAll();
    }

    public void saveUsuario(UsuariosDTO usuariosDTO){
        UsuariosEntity usuariosEntity = UsuariosEntity.builder()
                .nome(usuariosDTO.getNome())
                .idade(usuariosDTO.getIdade())
                .telefone(usuariosDTO.getTelefone())
                .build();

        usuarioRepository.save(usuariosEntity);
    }

    public UsuariosEntity findByTelefone(String telefone){
        UsuariosEntity usuarios = usuarioRepository.findByTelefone(telefone);

        if(usuarios != null){
            new NotFoundException("Usuario não identificado");
        }
        return  usuarios;
    }
}
