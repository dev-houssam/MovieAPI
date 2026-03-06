package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration de l'application pour la création d'un bean RestTemplate.
 *
 * Le RestTemplate est utilisé pour effectuer des appels HTTP vers des
 * services REST. Cette classe crée et configure un RestTemplate avec
 * des paramètres de temps de connexion et de lecture.
 */
@Configuration
public class RestTemplateConfig {

    /**
     * Crée un bean RestTemplate avec des paramètres de configuration personnalisés.
     *
     * @return un objet RestTemplate configuré.
     */
    @Bean
    public RestTemplate restTemplate() {

        // Création d'une instance de SimpleClientHttpRequestFactory
        // qui permet de configurer des paramètres spécifiques pour le RestTemplate.
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

        // Définition du délai de connexion à 2000 ms (2 secondes)
        factory.setConnectTimeout(2000);

        // Définition du délai de lecture à 2000 ms (2 secondes)
        factory.setReadTimeout(2000);

        // Retourne une nouvelle instance de RestTemplate configurée avec la factory
        return new RestTemplate(factory);
    }
}
