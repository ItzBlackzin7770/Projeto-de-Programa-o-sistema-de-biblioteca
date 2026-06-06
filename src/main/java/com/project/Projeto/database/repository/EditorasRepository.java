package com.project.Projeto.database.repository;

import com.project.Projeto.database.model.EditorasEntity;
import com.project.Projeto.database.model.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EditorasRepository extends JpaRepository<EditorasEntity, Integer> {

    @Query("""
            SELECT e FROM EditorasEntity e
            WHERE UPPER(e.telefone) = UPPER(:telefone)
            """)
    public EditorasEntity findByTelefone(@Param("telefone") String telefone);
}
