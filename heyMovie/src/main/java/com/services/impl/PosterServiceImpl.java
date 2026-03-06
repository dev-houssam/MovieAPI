package com.services.impl;

import com.services.external.PosterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

/**
 * Implémentation du service PosterService pour la gestion des affiches de films.
 *
 * - @Service : indique que cette classe est un service géré par Spring.
 * - @RequiredArgsConstructor : génère un constructeur pour l'injection
 *   des dépendances nécessaires, ici le RestTemplate.
 */
@Service
@RequiredArgsConstructor
public class PosterServiceImpl implements PosterService {

    private final RestTemplate restTemplate;

    // URL de l'API de gestion des affiches
    private final String POSTER_API_URL = "http://localhost:12005/posters/";

    /**
     * Récupère l'affiche d'un film par son titre.
     *
     * @param movieTitle le titre du film dont on veut récupérer l'affiche.
     * @return le poster sous forme de tableau d'octets, ou null
     *         si l'API est indisponible.
     */
    @Override
    public byte[] getPoster(String movieTitle) {
        String url = POSTER_API_URL + movieTitle;

        try {
            return restTemplate.getForObject(url, byte[].class);
        } catch (RestClientException e) {
            System.out.println("Poster API indisponible pour : " + movieTitle);
            return null; // Aucun poster, mais le film reste chargé
        }
    }

    /**
     * Télécharge une nouvelle affiche pour un film donné.
     *
     * @param movieTitle le titre du film pour lequel uploader l'affiche.
     * @param poster le poster sous forme de tableau d'octets à uploader.
     */
    @Override
    public void uploadPoster(String movieTitle, byte[] poster) {
        String url = POSTER_API_URL + movieTitle;

        try {
            restTemplate.postForObject(url, poster, Void.class);
        } catch (RestClientException e) {
            System.out.println("Impossible d'uploader le poster : " + movieTitle);
        }
    }
}
