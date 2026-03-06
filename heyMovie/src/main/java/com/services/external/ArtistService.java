package com.services.external;

import com.dtos.ArtistDto;
import java.util.List;

/**
 * Interface de service pour la gestion des artistes liés aux films.
 *
 * Méthodes :
 * - getArtistsByMovie(String movieTitle) : récupère la liste des
 *   artistes associés à un film spécifié par son titre.
 * - addArtists(String movieTitle, List<ArtistDto> artists) :
 *   ajoute des artistes à un film spécifié par son titre.
 */
public interface ArtistService {

    List<ArtistDto> getArtistsByMovie(String movieTitle);

    void addArtists(String movieTitle, List<ArtistDto> artists);
}
