package com.project.Projeto.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterDTO {
    @NotBlank
    private String nome;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate idade;
    @NotBlank
    private String telefone;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
}
