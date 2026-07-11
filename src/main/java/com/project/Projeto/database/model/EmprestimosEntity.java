package com.project.Projeto.database.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.Projeto.database.model.enums.EmprestimoStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "emprestimos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmprestimosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Builder.Default
    private LocalDate data_emprestimo = LocalDate.now();

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_devolucao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EmprestimoStatus status = EmprestimoStatus.ativo;

    @Column(nullable = false)
    private BigDecimal multa;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties("emprestimos")
    private UsuariosEntity usuariosEntity;


    @ManyToOne
    @JoinColumn(name = "livro_id")
    @JsonIgnoreProperties("emprestimos")
    private LivrosEntity livrosEntity;
}
