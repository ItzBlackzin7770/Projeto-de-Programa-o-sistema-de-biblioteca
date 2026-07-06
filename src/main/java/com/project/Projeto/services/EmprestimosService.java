package com.project.Projeto.services;


import com.project.Projeto.database.model.EmprestimosEntity;
import com.project.Projeto.database.model.LivrosEntity;
import com.project.Projeto.database.model.UsuariosEntity;
import com.project.Projeto.database.repository.EmprestimosRepository;
import com.project.Projeto.database.repository.LivrosRepository;
import com.project.Projeto.database.repository.UsuarioRepository;
import com.project.Projeto.dto.EmprestimosDTO;
import com.project.Projeto.dto.Projections.EmprestimosProjection;
import com.project.Projeto.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmprestimosService {
    private final EmprestimosRepository emprestimosRepository;
    private final UsuarioRepository usuarioRepository;
    private final LivrosRepository livrosRepository;

    public List<EmprestimosEntity> findAll(){
        return emprestimosRepository.findAll();
    }



    public void createEmprestimo(EmprestimosDTO emprestimosDTO) {

        UsuariosEntity usuariosEntity = usuarioRepository.findById(emprestimosDTO.getId_usuario())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        LivrosEntity livrosEntity = livrosRepository.findById(emprestimosDTO.getId_livro())
                .orElseThrow(() -> new NotFoundException("Livro não encontrado"));

        EmprestimosEntity emprestimosEntity = EmprestimosEntity.builder()
                .usuariosEntity(usuariosEntity)
                .livrosEntity(livrosEntity)
                .data_devolucao(emprestimosDTO.getData_devolucao())
                .data_emprestimo(LocalDate.now())
                .status(emprestimosDTO.getStatus())
                .multa(emprestimosDTO.getMulta())
                .build();


        emprestimosRepository.save(emprestimosEntity);
    }

    public List<EmprestimosProjection> getAllEmprestimos(){
        return emprestimosRepository.getAllEmprestimos();
    }
}
