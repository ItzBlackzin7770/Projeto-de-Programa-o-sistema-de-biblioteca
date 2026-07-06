package com.project.Projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.project.Projeto.database.repository")
public class ProjetoApplication {

	// TODO: Aprendir paginação e outros conceitos sobre JPA e aplicar ao projeto
	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}

}
