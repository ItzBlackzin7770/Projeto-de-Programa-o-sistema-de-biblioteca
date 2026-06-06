package com.project.Projeto.database.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "autores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AutoresEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate idade;

    @Column(nullable = false)
    private String graduacao;

    @Column(nullable = false)
    private String nacionalidade;

    @ManyToMany(mappedBy = "autores")
    @JsonIgnoreProperties("autores")
    Set<LivrosEntity> livros = new HashSet<>();
}
