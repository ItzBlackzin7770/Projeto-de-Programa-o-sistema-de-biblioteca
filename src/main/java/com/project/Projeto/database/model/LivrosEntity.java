package com.project.Projeto.database.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "livros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LivrosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate cadastro;

    @Column(nullable = false)
    private Integer produzidos;

    @Column(nullable = false)
    private Integer disponiveis;

    @Column(nullable = false, name = "gênero")
    private String genero;

    @Column(nullable = false, unique = true, columnDefinition = "INT(5)")
    private Integer codigo;

    // RELACIONAMENTO COM EDITORAS
    @ManyToOne
    @JoinColumn(name = "editora_id")
    @JsonIgnoreProperties("livros")
    private EditorasEntity editorasEntity;


    // RELACIONAMENTO COM EMPRESTIMOS
    @OneToMany(mappedBy = "livrosEntity")
    @JsonIgnoreProperties("livros")
    private Set<EmprestimosEntity> emprestimos = new HashSet<>();

    // RELACIONAMENTO COM AUTORES
    @ManyToMany
    @JoinTable(name = "autores_livros", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name = "autor_id"))
    @JsonIgnoreProperties("livros")
    private Set<AutoresEntity> autores = new HashSet<>();
}
