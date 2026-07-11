package com.project.Projeto.database.repository;

import com.project.Projeto.database.model.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<RolesEntity, Integer> {



    Optional<RolesEntity> findByRoles(String roles);
}
