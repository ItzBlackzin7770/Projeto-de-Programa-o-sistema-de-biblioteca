package com.project.Projeto.database.repository;

import com.project.Projeto.database.model.LivrosEntity;
import com.project.Projeto.database.model.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LivrosRepository extends JpaRepository<LivrosEntity, Integer> {

    @Query("""
            SELECT l FROM LivrosEntity l
            WHERE UPPER(l.nome) = UPPER(:name)
            """)
    public LivrosEntity findByName(@Param("name") String name);
}
