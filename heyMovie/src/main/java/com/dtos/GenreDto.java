package com.dtos;

import com.entities.Movie;
import lombok.*;

import java.util.Set;

/**
 * Classe DTO (Data Transfer Object) pour représenter un genre de film.
 * Utilise Lombok pour générer des méthodes utiles :
 * - @Data : pour getters, setters, toString, etc.
 * - @NoArgsConstructor : constructeur sans paramètres.
 * - @AllArgsConstructor : constructeur avec tous les paramètres.
 * - @Builder : modèle de conception pour simplifier la création d'instances.
 *
 * Attributs :
 * - id : identifiant unique du genre.
 * - titre : nom du genre.
 * - movies : ensemble des films associés à ce genre.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreDto {

    private Long id;
    private String titre;
    private Set<Movie> movies;
}
