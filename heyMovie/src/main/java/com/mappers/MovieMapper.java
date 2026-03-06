package com.mappers;

import com.entities.Movie;
import com.entities.Genre;
import com.dtos.MovieDto;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Classe pour mapper entre les objets Movie et MovieDto.
 *
 * Méthodes :
 * - toDto(Movie movie) : convertit une entité Movie en MovieDto.
 *   Utilise le builder pour créer l'objet DTO, transforme aussi
 *   les genres en ensemble d'identifiants.
 *
 * - toEntity(MovieDto dto, Set<Genre> genres) : convertit un MovieDto
 *   en entité Movie. Note : l'ID n'est pas mappé lors de la création
 *   pour éviter des erreurs lors de l'ajout d'un nouveau film.
 */
public class MovieMapper {

    public static MovieDto toDto(Movie movie) {
        return MovieDto.builder()
                .id(movie.getId())
                .titre(movie.getTitre())
                .annee_realisation(movie.getAnneeRealisation())
                .prix_location(movie.getPrixLocation())
                .age_minimum(movie.getAgeMinimum())
                .ouvert_location(movie.isOuvertLocation())
                .genres(
                        movie.getGenres()
                                .stream()
                                .map(Genre::getId)
                                .collect(Collectors.toSet())
                )
                .build();
    }

    public static Movie toEntity(MovieDto dto, Set<Genre> genres) {
        return Movie.builder()
                // NE PAS mapper l'id pour une création : une grosse erreur apparait au POST
                .titre(dto.getTitre())
                .anneeRealisation(dto.getAnnee_realisation())
                .prixLocation(dto.getPrix_location())
                .ageMinimum(dto.getAge_minimum())
                .ouvertLocation(dto.isOuvert_location())
                .genres(genres)
                .build();
    }
}
