package com.project.Projeto.database.repository;

import com.project.Projeto.database.model.AutoresEntity;
import com.project.Projeto.database.model.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoresRepository extends JpaRepository<AutoresEntity, Integer> {

}
