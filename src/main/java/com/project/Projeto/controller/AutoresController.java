package com.project.Projeto.controller;

import com.project.Projeto.database.model.AutoresEntity;
import com.project.Projeto.dto.AutoresDTO;
import com.project.Projeto.services.AutoresService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/autores")
@RequiredArgsConstructor
@Validated
public class AutoresController {

    private final AutoresService autoresService;

    @GetMapping
    public List<AutoresEntity> findAll(){
        return autoresService.findAll();
    }

    @PostMapping("/create")
    public String createAutor(@Valid @RequestBody AutoresDTO autoresDTO){
        return autoresService.createAutores(autoresDTO);
    }

    @GetMapping("/find")
    public AutoresEntity findByNome(@RequestParam String nome){
        return autoresService.findByNome(nome);
    }
}
