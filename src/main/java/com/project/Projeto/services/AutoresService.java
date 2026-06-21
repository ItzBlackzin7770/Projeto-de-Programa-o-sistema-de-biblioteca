package com.project.Projeto.services;

import com.project.Projeto.database.model.AutoresEntity;
import com.project.Projeto.database.repository.AutoresRepository;
import com.project.Projeto.dto.AutoresDTO;
import com.project.Projeto.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoresService {

    private final AutoresRepository autoresRepository;

    public List<AutoresEntity> findAll(){
        return autoresRepository.findAll();
    }

    public String createAutores(AutoresDTO autoresDTO){
        AutoresEntity newAutores = AutoresEntity.builder()
                .nome(autoresDTO.getNome())
                .idade(autoresDTO.getIdade())
                .graduacao(autoresDTO.getGraduacao())
                .nacionalidade(autoresDTO.getNacionalidade())
                .livros(autoresDTO.getLivros_id())
                .build();

        autoresRepository.save(newAutores);
        return "Autor criado com sucesso";
    }

    public AutoresEntity findByNome(String nome){
        return autoresRepository.findByNome(nome).orElseThrow(() -> new NotFoundException("Autor não encontrado"));
    }
}
