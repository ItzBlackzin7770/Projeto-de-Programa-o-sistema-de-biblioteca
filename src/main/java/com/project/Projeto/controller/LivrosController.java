package com.project.Projeto.controller;

import com.project.Projeto.database.model.LivrosEntity;
import com.project.Projeto.dto.LivrosDTO;
import com.project.Projeto.dto.Projections.LivrosProjection;
import com.project.Projeto.services.LivrosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public String createLivros(@Valid @RequestBody LivrosDTO livrosDTO){
        livrosService.createLivro(livrosDTO);
        return "Livro criado com sucesso";
    }

    @GetMapping("/livros")
    public LivrosEntity findByName(@RequestParam String name) {
        System.out.println("Nome encontrado: " + name);
        return livrosService.findByName(name);
    }

    @GetMapping("/get")
    public List<LivrosProjection> getAllLivros(){
        return livrosService.getAllLivros();
    }
}
