package com.services;

import com.dtos.MovieDto;

import java.util.List;

/**
 * Interface de service pour la gestion des films.
 *
 * Déclare les méthodes nécessaires pour effectuer des opérations
 * CRUD sur les films, ainsi que des opérations spécifiques
 * concernant la location des films.
 */
public interface MovieService {

 /**
  * Récupère la liste de tous les films.
  *
  * @return une liste de MovieDto représentant tous les films.
  */
 List<MovieDto> getAllMovies();

 /**
  * Récupère un film par son identifiant.
  *
  * @param id l'identifiant du film à récupérer.
  * @return un MovieDto représentant le film correspondant.
  */
 MovieDto getMovie(Long id);

 /**
  * Crée un nouveau film à partir des données fournies dans le DTO.
  *
  * @param dto les données du film à créer.
  * @return un MovieDto représentant le film créé.
  */
 MovieDto createMovie(MovieDto dto);

 /**
  * Supprime un film par son identifiant.
  *
  * @param id l'identifiant du film à supprimer.
  */
 void deleteMovie(Long id);

 /**
  * Ouvre la localisation d'un film pour la location.
  *
  * @param id l'identifiant du film.
  * @return un MovieDto représentant le film après l'ouverture.
  */
 MovieDto openLocation(Long id);

 /**
  * Ferme la localisation d'un film pour la location.
  *
  * @param id l'identifiant du film.
  * @return un MovieDto représentant le film après la fermeture.
  */
 MovieDto closeLocation(Long id);
}
