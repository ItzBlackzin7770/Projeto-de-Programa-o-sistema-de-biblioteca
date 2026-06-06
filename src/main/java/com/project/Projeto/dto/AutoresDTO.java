package com.project.Projeto.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
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
}
