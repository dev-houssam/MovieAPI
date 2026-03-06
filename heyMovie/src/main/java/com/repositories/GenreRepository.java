package com.repositories;

import com.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de dépôt pour les opérations liées à l'entité Genre.
 *
 * Extends JpaRepository pour bénéficier des fonctionnalités CRUD
 * prêtes à l'emploi telles que la sauvegarde, la recherche et la
 * suppression d'entités Genre.
 *
 * Paramètres :
 * - Genre : type d'entité à gérer.
 * - Long : type de l'identifiant de l'entité.
 */
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
