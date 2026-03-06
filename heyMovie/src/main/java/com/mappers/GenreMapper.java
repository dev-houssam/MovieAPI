package com.mappers;

import com.dtos.GenreDto;
import com.entities.Genre;
import org.springframework.stereotype.Component;

/**
 * Classe pour mapper entre les objets Genre et GenreDto.
 *
 * - @Component : indique que cette classe est un composant Spring et
 *   sera gérée par le conteneur IoC.
 *
 * Méthodes :
 * - toDto(Genre genre) : convertit une entité Genre en GenreDto.
 *   Renvoie null si l'entité est nulle.
 * - toEntity(GenreDto genreDto) : convertit un GenreDto en entité Genre.
 *   Renvoie null si le DTO est nul.
 */
@Component
public class GenreMapper {

    public GenreDto toDto(Genre genre) {
        if (genre == null) {
            return null;
        }

        GenreDto genreDto = new GenreDto();

        genreDto.setId(genre.getId());
        genreDto.setTitre(genre.getTitre());
        genreDto.setMovies(genre.getMovies());

        return genreDto;
    }

    public Genre toEntity(GenreDto genreDto) {
        if (genreDto == null) {
            return null;
        }

        Genre genre = new Genre();

        genre.setId(genreDto.getId());
        genre.setTitre(genreDto.getTitre());
        genre.setMovies(genreDto.getMovies());

        return genre;
    }
}
