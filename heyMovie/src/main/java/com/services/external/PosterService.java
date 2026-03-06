package com.services.external;

import org.springframework.stereotype.Service;

/**
 * Interface de service pour la gestion des affiches de films.
 *
 * Méthodes :
 * - getPoster(String movieTitle) : récupère l'affiche d'un film
 *   spécifié par son titre sous forme de tableau d'octets.
 * - uploadPoster(String movieTitle, byte[] poster) : permet
 *   de télécharger une nouvelle affiche pour un film donné.
 */
public interface PosterService {

    byte[] getPoster(String movieTitle);

    void uploadPoster(String movieTitle, byte[] poster);
}
