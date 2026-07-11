package com.project.Projeto.dto.Projections;

import com.project.Projeto.database.model.enums.EmprestimoStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface EmprestimosProjection {

    Integer getIdEmprestimo();
    LocalDate getDataEmprestimo();
    Integer getIdLivro();
    String getNomeLivro();
    Integer getIdUsuario();
    String getNomeUsuario();
    LocalDate getDataDevolucaoEmprestimo();
    EmprestimoStatus getStatusEmprestimo();
    BigDecimal getMulta();
}
