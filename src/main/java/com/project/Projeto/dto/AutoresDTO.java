package com.project.Projeto.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.Projeto.database.model.LivrosEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AutoresDTO {

    @NotBlank
    private String nome;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate idade;

    @NotBlank
    private String graduacao;

    @NotBlank
    private String nacionalidade;

    private Set<Integer> livros_id;
}
