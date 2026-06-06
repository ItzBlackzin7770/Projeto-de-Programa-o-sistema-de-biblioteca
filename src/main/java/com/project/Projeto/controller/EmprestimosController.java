package com.project.Projeto.controller;

import com.project.Projeto.database.model.EmprestimosEntity;
import com.project.Projeto.dto.EmprestimosDTO;
import com.project.Projeto.services.EmprestimosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/emprestimos")
@RequiredArgsConstructor
@Validated
public class EmprestimosController {
    private final EmprestimosService emprestimosService;

    @GetMapping
    public List<EmprestimosEntity> findAll(){
        return emprestimosService.findAll();
    }

    @PostMapping("/create")
    public void createEmprestimos(@Valid @RequestBody EmprestimosDTO emprestimosDTO){
        emprestimosService.createEmprestimo(emprestimosDTO);
    }
}
