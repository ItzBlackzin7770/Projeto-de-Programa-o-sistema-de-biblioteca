package com.project.Projeto.services;

import com.project.Projeto.database.model.EmprestimosEntity;
import com.project.Projeto.database.model.UsuariosEntity;
import com.project.Projeto.database.repository.EmprestimosRepository;
import com.project.Projeto.database.repository.UsuarioRepository;
import com.project.Projeto.dto.UsuariosDTO;
import com.project.Projeto.exceptions.BadRequestException;
import com.project.Projeto.exceptions.NotFoundException;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuariosService {
    private final EmprestimosRepository emprestimosRepository;

    private final UsuarioRepository usuarioRepository;

    public List<UsuariosEntity> findAll(){
        return usuarioRepository.findAll();
    }

    public void saveUsuario(UsuariosDTO usuariosDTO){
        UsuariosEntity usuarios = usuarioRepository.findByEmail(usuariosDTO.getEmail()).orElse(null);

        if (usuarios != null){
            new BadRequestException("Usuário já cadastrrado");
        }

        UsuariosEntity usuariosEntity = UsuariosEntity.builder()
                .nome(usuariosDTO.getNome())
                .idade(usuariosDTO.getIdade())
                .telefone(usuariosDTO.getTelefone())
                .email(usuariosDTO.getEmail())
                .build();

        usuarioRepository.save(usuariosEntity);
    }

    public UsuariosEntity findByTelefone(String telefone) throws NotFoundException{
        UsuariosEntity usuarios = usuarioRepository.findByTelefone(telefone);

        if (usuarios == null){
             throw new NotFoundException("Usuário não encontrado");
        }

        return usuarios;
    }


    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(Integer id) throws NotFoundException{
        UsuariosEntity user = usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuarios não encontrado"));

        List<Integer> userEmprestimos = user.getEmprestimos().
                stream().map(EmprestimosEntity::getId).toList();

        emprestimosRepository.deleteAllById(userEmprestimos);

        usuarioRepository.deleteById(id);
    }
}
