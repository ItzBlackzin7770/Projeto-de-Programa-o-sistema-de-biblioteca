package com.project.Projeto.database.repository;

import com.project.Projeto.database.model.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuariosEntity, Integer> {

    @Query(value = """
            select u from UsuariosEntity u 
            where UPPER(u.telefone) = UPPER(:telefone)
            """)
    public UsuariosEntity findByTelefone(@Param("telefone") String telefone);

    @Query(value = """
            SELECT u FROM UsuariosEntity u
            WHERE UPPER(u.email) = UPPER(:email)
            """)
    Optional<UsuariosEntity> findByEmail(@Param("email") String email);

}
