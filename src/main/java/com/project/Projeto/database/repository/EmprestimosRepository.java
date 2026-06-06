package com.project.Projeto.database.repository;

import com.project.Projeto.database.model.EmprestimosEntity;
import com.project.Projeto.database.model.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimosRepository extends JpaRepository<EmprestimosEntity, Integer> {

}
