package com.project.Projeto.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.Projeto.database.model.EmprestimoStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmprestimosDTO {
    @NotNull
    private Integer id_usuario;

    @NotNull
    private Integer id_livro;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_emprestimo;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_devolucao;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EmprestimoStatus status;

    @NotNull
    private BigDecimal multa;
}
