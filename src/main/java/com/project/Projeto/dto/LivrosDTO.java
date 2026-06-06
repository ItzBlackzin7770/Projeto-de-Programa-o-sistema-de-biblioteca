package com.project.Projeto.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.Projeto.database.model.AutoresEntity;
import com.project.Projeto.database.model.EmprestimoStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LivrosDTO {

    @NotBlank
    private String Nome;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate cadastro;
    @NotNull
    private Integer produzidos;
    @NotNull
    private Integer disponiveis;
    @NotNull
    private String genero;
    @NotNull
    private Integer codigo;
    @NotNull
    private Integer id_editora;
    @NotEmpty
    private Set<Integer> id_autores;
}
