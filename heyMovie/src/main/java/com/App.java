package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale de l'application Spring Boot.
 *
 * - @SpringBootApplication : annotation qui active la configuration
 *   automatique de Spring Boot et permet la détection des composants.
 *
 * La méthode main  () sert de point d'entrée pour l'application.
 * Elle démarre l'application Spring en lançant le contexte
 * de l'application.
 */
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		// Démarre l'application Spring Boot :
		SpringApplication.run(App.class, args);
	}
}
