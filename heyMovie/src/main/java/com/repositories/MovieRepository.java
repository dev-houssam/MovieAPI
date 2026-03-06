package com.repositories;

import com.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface de dépôt pour les opérations liées à l'entité Movie.
 *
 * Extends JpaRepository pour bénéficier des opérations CRUD
 * standard sur les entités Movie.
 *
 * Méthodes :
 * - findAllWithGenres() : utilise une requête JPQL personnalisée
 *   pour récupérer tous les films avec leurs genres associés
 *   en utilisant un chargement en avance (LEFT JOIN FETCH).
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("""
    SELECT m
    FROM Movie m
    LEFT JOIN FETCH m.genres
""")
    List<Movie> findAllWithGenres();
}
