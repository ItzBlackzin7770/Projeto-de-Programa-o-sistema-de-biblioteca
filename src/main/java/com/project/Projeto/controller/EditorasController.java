package com.project.Projeto.controller;

import com.project.Projeto.database.model.EditorasEntity;
import com.project.Projeto.dto.EditorasDTO;
import com.project.Projeto.exceptions.NotFoundException;
import com.project.Projeto.services.EditorasService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/editora")
@RequiredArgsConstructor
@Validated
public class EditorasController {
    private final EditorasService editorasService;

    @GetMapping
    public List<EditorasEntity> findAll(){
        return editorasService.findAll();
    }

    @PostMapping("/create")
    public String createEditora(@Valid @RequestBody EditorasDTO editorasDTO){
        return editorasService.createEditora(editorasDTO);
    }

    @GetMapping("/editoras")
    public EditorasEntity findByTelefone(@RequestParam String telefone) throws NotFoundException {
        return editorasService.findByTelefone(telefone);
    }
}
