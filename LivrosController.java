package com.project.Projeto.controller;

import com.project.Projeto.database.model.LivrosEntity;
import com.project.Projeto.dto.LivrosDTO;
import com.project.Projeto.dto.Projections.LivrosProjection;
import com.project.Projeto.exceptions.NotFoundException;
import com.project.Projeto.services.LivrosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public String createLivros(@Valid @RequestBody LivrosDTO livrosDTO) throws NotFoundException{
        livrosService.createLivro(livrosDTO);
        return "Livro criado com sucesso";
    }

    @GetMapping("/livros")
    public LivrosEntity findByName(@RequestParam String name) throws NotFoundException {
        System.out.println("Nome encontrado: " + name);
        return livrosService.findByName(name);
    }

    @GetMapping("/getProjection")
    public List<LivrosProjection> getAllLivros(){
        return livrosService.getAllLivros();
    }

    @GetMapping("/getPage")
    public Page<LivrosProjection> getAllLivrosPage(@RequestParam Integer page, @RequestParam Integer size){
        return livrosService.getAllLivrosPage(page, size);
    }
}
