package com.project.Projeto.controller;

import com.project.Projeto.database.model.LivrosEntity;
import com.project.Projeto.dto.LivrosDTO;
import com.project.Projeto.services.LivrosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/v1/livros")
@RequiredArgsConstructor
public class LivrosController {

    private final LivrosService livrosService;

    @GetMapping
    public List<LivrosEntity> findAll(){
        return livrosService.findAll();
    }

    @PostMapping("/create")
    public String createLivros(@Valid LivrosDTO livrosDTO){
        livrosService.createLivro(livrosDTO);
        return "Livro criado com sucesso";
    }
}
