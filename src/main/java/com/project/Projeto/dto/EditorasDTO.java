package com.project.Projeto.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.Projeto.database.model.EmprestimoStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditorasDTO {
    @NotBlank
    private String nome;

    @NotNull
    private LocalDate criado;

    @NotBlank
    private String graduacao;

    @NotBlank
    private String nacionalidade;

    @NotNull
    private BigDecimal multa;
}
