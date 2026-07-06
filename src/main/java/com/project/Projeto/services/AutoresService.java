package com.project.Projeto.services;

import com.project.Projeto.database.model.AutoresEntity;
import com.project.Projeto.database.model.LivrosEntity;
import com.project.Projeto.database.repository.AutoresRepository;
import com.project.Projeto.database.repository.LivrosRepository;
import com.project.Projeto.dto.AutoresDTO;
import com.project.Projeto.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AutoresService {

    private final AutoresRepository autoresRepository;
    private final LivrosRepository livrosRepository;

    public List<AutoresEntity> findAll(){
        return autoresRepository.findAll();
    }

    public String createAutores(AutoresDTO autoresDTO){
        Set<LivrosEntity> livrosEntities = new HashSet<>();

        for (Integer autores : autoresDTO.getLivros_id()) {
            LivrosEntity autor = livrosRepository.findById(autores).orElseThrow(() -> new NotFoundException(String.format("Autor %s não encontrado", autores)));

            livrosEntities.add(autor);
        }

        AutoresEntity newAutores = AutoresEntity.builder()
                .nome(autoresDTO.getNome())
                .idade(autoresDTO.getIdade())
                .graduacao(autoresDTO.getGraduacao())
                .nacionalidade(autoresDTO.getNacionalidade())
                .livros(livrosEntities)
                .build();

        autoresRepository.save(newAutores);
        return "Autor criado com sucesso";
    }

    public AutoresEntity findByNome(String nome){
        return autoresRepository.findByNome(nome).orElseThrow(() -> new NotFoundException("Autor não encontrado"));
    }
}
