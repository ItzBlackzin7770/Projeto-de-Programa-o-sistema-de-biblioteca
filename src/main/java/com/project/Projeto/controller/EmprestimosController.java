package com.project.Projeto.controller;

import com.project.Projeto.database.model.EmprestimosEntity;
import com.project.Projeto.dto.EmprestimosDTO;
import com.project.Projeto.dto.Projections.EmprestimosProjection;
import com.project.Projeto.exceptions.NotFoundException;
import com.project.Projeto.services.EmprestimosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public void createEmprestimos(@Valid @RequestBody EmprestimosDTO emprestimosDTO) throws NotFoundException {
        emprestimosService.createEmprestimo(emprestimosDTO);
    }

    @GetMapping("/getProjection")
    public List<EmprestimosProjection> getAllEmprestimos(){
        return emprestimosService.getAllEmprestimos();
    }

    @GetMapping("/getPage")
    public Page<EmprestimosProjection> getAllEmprestimosPage(@RequestParam Integer page, @RequestParam Integer size) {
        return emprestimosService.getAllEmprestimosPage(page, size);
    }
}
