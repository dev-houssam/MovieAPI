package com.services;

import com.dtos.GenreDto;

import java.util.List;

/**
 * Interface définissant les opérations métier disponibles pour la gestion des genres.
 * Cette interface suit le principe d'Interface Segregation (SOLID).
 */
public interface GenreService {
    /**
     * Sauvegarde un genre dans le système
     * @param genreDto les données du genre à sauvegarder
     * @return le genre sauvegardé avec son ID généré
     */
    GenreDto saveGenre(GenreDto genreDto);

    /**
     * Récupère un genre par son identifiant
     * @param genreId l'identifiant du genre recherché
     * @return le genre trouvé
     * @throws jakarta.persistence.EntityNotFoundException si le genre n'existe pas
     */
    GenreDto getGenreById(Long genreId);

    /**
     * Supprime un genre du système
     * @param genreId l'identifiant du genre à supprimer
     * @return true si la suppression a réussi
     */
    boolean deleteGenre(Long genreId);

    /**
     * Récupère tous les genres du système
     * @return la liste des genres
     */
    List<GenreDto> getAllGenres();
    //List<ArtistDto> getAllArtists();
    //List<GenreDto> getAllGenres();
}
