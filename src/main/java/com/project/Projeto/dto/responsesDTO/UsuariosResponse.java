package com.project.Projeto.dto.responsesDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.Projeto.database.model.EmprestimosEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsuariosResponse {
    private int id;
    private String nome;
    private LocalDate idade;
    private String telefone;

}
