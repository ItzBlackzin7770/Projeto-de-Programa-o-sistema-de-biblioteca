package com.project.Projeto.dto.Projections;

import java.time.LocalDate;

public interface LivrosProjection {

    Integer getIdLivro();
    String getNomeLivro();
    LocalDate getCadastroLivro();
    Integer getDisponiveisLivro();
    String getGêneroLivro();
    Integer getCodigoLivro();
    Integer getIdEditora();
    String getNomeEditora();
    String getTelefoneEditora();
    Integer getIdAutor();
    String getNomeAutor();

}
