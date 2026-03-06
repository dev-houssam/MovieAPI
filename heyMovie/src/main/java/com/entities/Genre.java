package com.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * Classe représentant un genre de film dans le modèle de données.
 *
 * Utilise les annotations JPA pour la persistance et Lombok pour simplifier
 * la gestion des méthodes :
 * - @Entity : indique que cette classe est une entité persistante.
 * - @Data : fournit des méthodes automatiques pour les getters, setters,
 *   toString, equals et hashCode.
 * - @Builder : permet de construire des instances de manière fluide
 *   et lisible.
 * - @NoArgsConstructor : crée un constructeur sans paramètres.
 * - @AllArgsConstructor : crée un constructeur avec tous les paramètres.
 *
 * Attributs :
 * - id : identifiant unique du genre, généré automatiquement.
 * - titre : nom du genre de film.
 * - movies : ensemble des films associés à ce genre,
 *   relation Many-to-Many avec l'entité Movie.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies;
}
