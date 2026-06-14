package com.project.Projeto.database.repository;

import com.project.Projeto.database.model.LivrosEntity;
import com.project.Projeto.database.model.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LivrosRepository extends JpaRepository<LivrosEntity, Integer> {

    @Query(value = """
            SELECT l FROM LivrosEntity l
            WHERE UPPER(nome) = UPPER(:name)
            """)
    public LivrosEntity findByName(@Param("name") String name);
}
