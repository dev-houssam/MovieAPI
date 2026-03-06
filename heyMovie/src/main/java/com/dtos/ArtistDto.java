package com.dtos;

import lombok.Data;

/**
 * Classe DTO (Data Transfer Object) représentant un artiste.
 *
 * Cette classe utilise l'annotation Lombok @Data pour générer automatiquement
 * des méthodes getter, setter, toString, equals et hashCode pour les
 * attributs id, nom, prenom et role.
 *
 * - id : identifiant unique de l'artiste.
 * - nom : nom de l'artiste.
 * - prenom : prénom de l'artiste.
 * - role : rôle de l'artiste (par exemple, acteur, réalisateur, etc.).
 */
@Data
public class ArtistDto {

    private Long id;
    private String nom;
    private String prenom;
    private String role;
}
