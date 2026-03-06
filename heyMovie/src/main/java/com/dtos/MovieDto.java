package com.dtos;

import lombok.*;

import java.util.List;
import java.util.Set;

/**
 * Classe DTO (Data Transfer Object) pour représenter un film.
 *
 * Utilise Lombok pour générer automatiquement des méthodes pratiques :
 * - @Data : fournit des getters, setters, toString, equals et hashCode.
 * - @NoArgsConstructor : crée un constructeur sans paramètres.
 * - @AllArgsConstructor : crée un constructeur avec tous les paramètres.
 * - @Builder : permet de construire des instances de manière fluide et lisible.
 *
 * Attributs :
 * - id : identifiant unique du film.
 * - titre : titre du film.
 * - annee_realisation : année de réalisation du film.
 * - prix_location : coût de la location du film.
 * - age_minimum : âge minimum requis pour visionner le film.
 * - ouvert_location : état indiquant si le film est actuellement disponible à la location.
 * - genres : ensemble d'identifiants des genres associés au film.
 * - poster : tableau d'octets représentant l'image de l'affiche du film.
 * - artists : liste d'objets ArtistDto représentant les artistes associés au film.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDto {

	private Long id;

	private String titre;

	private int annee_realisation;

	private double prix_location;

	private int age_minimum;

	private boolean ouvert_location;

	private Set<Long> genres;

	private byte[] poster;

	private List<ArtistDto> artists;

}
