package com.project.Projeto.database.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "editoras")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EditorasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate criado;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String nacionalidade;

    @OneToMany(mappedBy = "editorasEntity")
    @JsonIgnoreProperties("editoras")
    private Set<LivrosEntity> livros = new HashSet<>();
}
