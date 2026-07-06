package com.project.Projeto.database.repository;

import com.project.Projeto.database.model.LivrosEntity;
import com.project.Projeto.dto.Projections.LivrosProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivrosRepository extends JpaRepository<LivrosEntity, Integer> {

    @Query(value = """
            SELECT l FROM LivrosEntity l
            WHERE UPPER(nome) = UPPER(:name)
            """)
    public LivrosEntity findByName(@Param("name") String name);


    @NativeQuery(value = """
            SELECT
                lv.id           IdLivro,
                lv.nome         NomeLivro,
                lv.cadastro         CadastroLivro,
                lv.disponiveis      DisponiveisLivro,
                lv.gênero           GêneroLivro,
                lv.codigo           CodigoLivro,
                ed.id           IdEditora,
                ed.nome         NomeEditora,
                ed.telefone         TelefoneEditora,
                at.id           IdAutor,
                at.nome         NomeAutor
            FROM livros lv
            LEFT JOIN editoras ed ON ed.id = lv.editora_id
            LEFT JOIN autores_livros al ON al.livro_id = lv.id
            LEFT JOIN autores at ON al.autor_id = at.id
            """)
    List<LivrosProjection> getAllLivros();
}
