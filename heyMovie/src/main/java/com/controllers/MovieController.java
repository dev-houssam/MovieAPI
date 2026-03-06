package com.controllers;

import com.services.MovieService;
import com.dtos.MovieDto;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des films.
 *
 * Ce contrôleur permet d'effectuer des opérations CRUD (Créer, Lire,
 * Mettre à jour, Supprimer) sur les objets MovieDto via des
 * endpoints HTTP.
 */
@RestController
@RequestMapping("/movies")
public class MovieController {

	private final MovieService service;

	/**
	 * Constructeur du contrôleur qui injecte le service de films.
	 *
	 * @param service une instance de MovieService pour gérer les opérations sur les films.
	 */
	public MovieController(MovieService service){
		this.service = service;
	}

	/**
	 * Récupère tous les films disponibles.
	 *
	 * @return une liste de MovieDto représentant tous les films.
	 */
	@GetMapping
	public List<MovieDto> getAllMovies(){
		return service.getAllMovies();
	}

	/**
	 * Récupère un film spécifique par son identifiant.
	 *
	 * @param id l'identifiant du film à récupérer.
	 * @return l'objet MovieDto correspondant au film.
	 */
	@GetMapping("/{id}")
	public MovieDto getMovie(@PathVariable Long id){
		return service.getMovie(id);
	}

	/**
	 * Crée un nouveau film à partir des données fournies dans le corps de la requête.
	 *
	 * @param dto l'objet MovieDto contenant les informations du film à créer.
	 * @return l'objet MovieDto du film créé.
	 */
	@PostMapping
	public MovieDto createMovie(@RequestBody MovieDto dto){
		return service.createMovie(dto);
	}

	/**
	 * Supprime un film par son identifiant.
	 *
	 * @param id l'identifiant du film à supprimer.
	 */
	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable Long id){
		service.deleteMovie(id);
	}

	/**
	 * Ouvre la localisation d'un film par son identifiant.
	 *
	 * @param id l'identifiant du film pour lequel ouvrir la localisation.
	 * @return l'objet MovieDto du film avec la localisation ouverte.
	 */
	@PutMapping("/{id}/open-location")
	public MovieDto openLocation(@PathVariable Long id){
		return service.openLocation(id);
	}

	/**
	 * Ferme la localisation d'un film par son identifiant.
	 *
	 * @param id l'identifiant du film pour lequel fermer la localisation.
	 * @return l'objet MovieDto du film avec la localisation fermée.
	 */
	@PutMapping("/{id}/close-location")
	public MovieDto closeLocation(@PathVariable Long id){
		return service.closeLocation(id);
	}
}
