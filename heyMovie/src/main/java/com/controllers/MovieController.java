package com.controllers;

import com.dtos.MovieDto;
import org.springframework.web.bind.annotation.*;

import com.services.impl.MovieServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private final MovieServiceImpl movieService;

	public MovieController(MovieServiceImpl movieService) {
		this.movieService = movieService;
	}

	/**
	 * <p>Get all movies in the system</p>
	 * @return List<MovieDto>
	 */
	@GetMapping
	public List<MovieDto> getMovies() {
		return movieService.getAllMovies();
	}

	/**
	 * Method to get the movie based on the ID
	 */
	@GetMapping("/{id}")
	public MovieDto getMovie(@PathVariable Long id){
		return movieService.getMovieById(id);
	}

	/**
	 * Create a new Movie in the system
	 */
	@PostMapping
	public MovieDto saveMovie(final @RequestBody MovieDto movieDto){
		return movieService.saveMovie(movieDto);
	}

	/**
	 * Delete a movie by it's id
	 */
	@DeleteMapping("/{id}")
	public Boolean deleteMovie(@PathVariable Long id){
		return movieService.deleteMovie(id);
	}

}
