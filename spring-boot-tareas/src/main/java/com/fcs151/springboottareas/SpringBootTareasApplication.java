package com.fcs151.springboottareas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.fcs151.springboottareas.repositories")
@SpringBootApplication
public class SpringBootTareasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTareasApplication.class, args);
	}
}
