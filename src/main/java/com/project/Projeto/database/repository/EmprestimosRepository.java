package com.project.Projeto.database.repository;

import com.project.Projeto.database.model.EmprestimosEntity;
import com.project.Projeto.dto.Projections.EmprestimosProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.util.List;

public interface EmprestimosRepository extends JpaRepository<EmprestimosEntity, Integer> {

    @NativeQuery(value = """
            SELECT
                em.id           IdEmprestimo,
                em.data_emprestimo      DataEmprestimo,
                lv.id       IdLivro,
                lv.nome         NomeLivro,
                us.id           IdUsuario,
                us.nome         NomeUsuario,
                em.data_devolucao       DataDevolucaoEmprestimo,
                em.status       StatusEmprestimo,
                em.multa        Multa
            FROM emprestimos em
            INNER JOIN livros lv ON lv.id = em.livro_id
            INNER JOIN usuarios us ON us.id = em.usuario_id
            """)
    List<EmprestimosProjection> getAllEmprestimos();

}
