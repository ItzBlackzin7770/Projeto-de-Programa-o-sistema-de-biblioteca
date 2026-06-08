package com.project.Projeto.controller;

import com.project.Projeto.database.model.UsuariosEntity;
import com.project.Projeto.dto.UsuariosDTO;
import com.project.Projeto.services.UsuariosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
@RequiredArgsConstructor
@Validated
public class UsuariosController {

    private final UsuariosService usuariosService;

    @GetMapping
    public List<UsuariosEntity> findAll(){
        return usuariosService.findAll();
    }



    @PostMapping
    public void saveUsuarios(@Valid @RequestBody UsuariosDTO usuariosDTO){
        usuariosService.saveUsuario(usuariosDTO);
    }

    @GetMapping("/users/{telefone}")
    public ResponseEntity<UsuariosEntity> findByTelefone(@PathVariable String telefone){
        UsuariosEntity usuario = usuariosService.findByTelefone(telefone);
        return ResponseEntity.ok(usuario);
    }

}

