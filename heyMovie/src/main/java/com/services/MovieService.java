package com.services;

import com.dtos.MovieDto;

import java.util.List;


 import com.dtos.MovieDto;
 import java.util.List;

 public interface MovieService {

 List<MovieDto> getAllMovies();

 MovieDto getMovie(Long id);

 MovieDto createMovie(MovieDto dto);

 void deleteMovie(Long id);

  MovieDto openLocation(Long id);

  MovieDto closeLocation(Long id);
 }