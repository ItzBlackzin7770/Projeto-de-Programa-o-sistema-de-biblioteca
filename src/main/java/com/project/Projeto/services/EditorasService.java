package com.project.Projeto.services;

import com.project.Projeto.database.model.EditorasEntity;
import com.project.Projeto.database.repository.EditorasRepository;
import com.project.Projeto.dto.EditorasDTO;
import com.project.Projeto.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EditorasService {
    private final EditorasRepository editorasRepository;

    public List<EditorasEntity> findAll(){
        return editorasRepository.findAll();
    }

    public String createEditora(EditorasDTO editorasDTO){
        EditorasEntity newEditora = EditorasEntity.builder()
                .nome(editorasDTO.getNome())
                .criado(editorasDTO.getCriado())
                .nacionalidade(editorasDTO.getNacionalidade())
                .telefone(editorasDTO.getNacionalidade())
                .build();

        editorasRepository.save(newEditora);

        return "Editora criada com sucesso";
    }

    public EditorasEntity findByTelefone(String telefone){

        EditorasEntity entity = editorasRepository.findByTelefone(telefone);

        if (entity == null) {
            throw new NotFoundException("Editora não encontrada");
        }

        return entity;

    }
}
