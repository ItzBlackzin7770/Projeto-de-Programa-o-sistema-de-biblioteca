package com.project.Projeto.services;

import com.project.Projeto.database.model.AutoresEntity;
import com.project.Projeto.database.model.EditorasEntity;
import com.project.Projeto.database.model.LivrosEntity;
import com.project.Projeto.database.repository.AutoresRepository;
import com.project.Projeto.database.repository.EditorasRepository;
import com.project.Projeto.database.repository.LivrosRepository;
import com.project.Projeto.dto.LivrosDTO;
import com.project.Projeto.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LivrosService {

    private final LivrosRepository livrosRepository;
    private final EditorasRepository editorasRepository;
    private final AutoresRepository autoresRepository;

    public List<LivrosEntity> findAll(){
        return livrosRepository.findAll();
    }

    public void createLivro(LivrosDTO livrosDTO){
        EditorasEntity editorasEntity = editorasRepository.findById(livrosDTO.getId_editora())
                .orElseThrow(() -> new NotFoundException("Editora não identificada"));

        Set<AutoresEntity> autoresEntities = new HashSet<>();

        for (Integer autores : livrosDTO.getId_autores()) {
            AutoresEntity autor = autoresRepository.findById(autores).orElseThrow(() -> new NotFoundException(String.format("Autor %s não identificado", autores)));

            autoresEntities.add(autor);
        }


        LivrosEntity livrosEntity = LivrosEntity.builder()
                .nome(livrosDTO.getNome())
                .cadastro(livrosDTO.getCadastro())
                .produzidos(livrosDTO.getProduzidos())
                .disponiveis(livrosDTO.getDisponiveis())
                .genero(livrosDTO.getGenero())
                .codigo(livrosDTO.getCodigo())
                .editorasEntity(editorasEntity)
                .autores(autoresEntities)
                .build();

        livrosRepository.save(livrosEntity);
    }

    public LivrosEntity findByName(String name){
        LivrosEntity livrosEntity = livrosRepository.findByName(name);


        if (livrosEntity == null) {
            throw new NotFoundException("Livro não encontrada");
        }

        return livrosEntity;

    }
}
