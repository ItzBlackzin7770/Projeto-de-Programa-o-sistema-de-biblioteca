package com.project.Projeto.database.repository;

import com.project.Projeto.database.model.AutoresEntity;
import com.project.Projeto.database.model.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AutoresRepository extends JpaRepository<AutoresEntity, Integer> {

    @Query("""
            SELECT a FROM AutoresEntity a
            WHERE UPPER(a.nome) = UPPER(:nome)
            """)
    public Optional<AutoresEntity> findByNome(@Param("nome") String nome);
}
