package com.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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