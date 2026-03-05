package com.controllers;

import com.services.MovieService;
import com.dtos.MovieDto;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private final MovieService service;

	public MovieController(MovieService service){
		this.service = service;
	}

	@GetMapping
	public List<MovieDto> getAllMovies(){
		return service.getAllMovies();
	}

	@GetMapping("/{id}")
	public MovieDto getMovie(@PathVariable Long id){
		return service.getMovie(id);
	}

	@PostMapping
	public MovieDto createMovie(@RequestBody MovieDto dto){
		return service.createMovie(dto);
	}

	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable Long id){
		service.deleteMovie(id);
	}

	@PutMapping("/{id}/open-location")
	public MovieDto openLocation(@PathVariable Long id){
		return service.openLocation(id);
	}

	@PutMapping("/{id}/close-location")
	public MovieDto closeLocation(@PathVariable Long id){
		return service.closeLocation(id);
	}
}