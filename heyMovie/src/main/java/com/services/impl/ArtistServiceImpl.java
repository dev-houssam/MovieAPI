package com.services.impl;

import com.dtos.ArtistDto;
import com.services.external.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Implémentation du service ArtistService pour interagir avec l'API externe
 * de gestion des artistes.
 *
 * - @Service : marque cette classe comme un service Spring.
 * - @RequiredArgsConstructor : génère un constructeur pour injecter
 *   les dépendances finales (ici, RestTemplate).
 */
@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final RestTemplate restTemplate;

    // URL de l'API des artistes
    private final String ARTIST_API_URL = "http://localhost:12103/artists/";

    /**
     * Récupère la liste des artistes associés à un film donné par son titre.
     *
     * @param movieTitle le titre du film.
     * @return une liste d'ArtistDto ou une liste vide en cas d'erreur
     *         ou si aucun artiste n'est trouvé.
     */
    @Override
    public List<ArtistDto> getArtistsByMovie(String movieTitle) {
        try {
            String url = ARTIST_API_URL + movieTitle;
            ArtistDto[] artists = restTemplate.getForObject(url, ArtistDto[].class);

            // Vérifie si le tableau est null et renvoie une liste vide si nécessaire
            if (artists == null) {
                return Collections.emptyList();
            }

            return Arrays.asList(artists);

        } catch (RestClientException e) {
            System.out.println("Artist API indisponible : " + e.getMessage());
            return Collections.emptyList();
        }
    }

    /**
     * Ajoute une liste d'artistes pour un film donné par son titre.
     *
     * @param movieTitle le titre du film.
     * @param artists la liste des artistes à ajouter.
     */
    @Override
    public void addArtists(String movieTitle, List<ArtistDto> artists) {
        try {
            String url = ARTIST_API_URL + movieTitle;
            restTemplate.postForObject(url, artists, Void.class);

        } catch (RestClientException e) {
            System.out.println("Impossible d'ajouter les artistes : " + e.getMessage());
        }
    }
}
