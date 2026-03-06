package com.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * Classe représentant un film dans la base de données.
 *
 * - @Entity : indique une entité JPA.
 * - @Table : spécifie le nom de la table.
 * - @Data : génère getters, setters, toString, etc.
 * - @NoArgsConstructor et @AllArgsConstructor : constructeurs générés.
 * - @Builder : permet un constructeur fluide.
 *
 * Attributs :
 * - id : identifiant unique.
 * - titre : titre du film (unique et non nul).
 * - anneeRealisation : année de sortie.
 * - prixLocation : coût de la location.
 * - ageMinimum : limite d'âge pour le film.
 * - ouvertLocation : disponibilité à la location.
 * - genres : ensemble de genres associés (relation Many-to-Many).
 */
@Entity
@Table(name = "movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String titre;

	@Column(name = "annee_realisation")
	private int anneeRealisation;

	@Column(name = "prix_location")
	private double prixLocation;

	@Column(name = "age_minimum")
	private int ageMinimum;

	@Column(name = "ouvert_location")
	private boolean ouvertLocation;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "movies_genres",
			joinColumns = @JoinColumn(name = "movie_id"),
			inverseJoinColumns = @JoinColumn(name = "genre_id")
	)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<Genre> genres;
}
