package com.services.impl;

import com.services.MovieService;
import com.repositories.MovieRepository;
import com.repositories.GenreRepository;
import com.mappers.MovieMapper;
import com.dtos.MovieDto;
import com.entities.Movie;
import com.entities.Genre;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

import com.services.external.PosterService;
import com.services.external.ArtistService;
import com.dtos.ArtistDto;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

	private final MovieRepository movieRepository;
	private final GenreRepository genreRepository;


	private final PosterService posterService;
	private final ArtistService artistService;

	@Override
	public List<MovieDto> getAllMovies() {

		return movieRepository.findAll()
				.stream()
				.map(MovieMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public MovieDto getMovie(Long id) {

		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Movie not found"));

		MovieDto dto = MovieMapper.toDto(movie);

		// récupération du poster
		byte[] poster = posterService.getPoster(movie.getTitre());
		dto.setPoster(poster);

		// récupération des artistes
		List<ArtistDto> artists =
				artistService.getArtistsByMovie(movie.getTitre());

		dto.setArtists(artists);

		return dto;
	}

	@Override
	public MovieDto createMovie(MovieDto dto){

		Set<Genre> genres = new HashSet<>(
				genreRepository.findAllById(dto.getGenres())
		);

		Movie movie = MovieMapper.toEntity(dto, genres);

		movie = movieRepository.save(movie);

		// Poster optionnel
		if (dto.getPoster() != null && dto.getPoster().length > 0) {
			try {
				posterService.uploadPoster(movie.getTitre(), dto.getPoster());
			} catch (Exception e) {
				log.warn("Poster API indisponible");
			}
		}

		// Artists optionnels
		if(dto.getArtists() != null && !dto.getArtists().isEmpty()){
			try {
				artistService.addArtists(movie.getTitre(), dto.getArtists());
			} catch (Exception e) {
				log.warn("Artist API indisponible");
			}
		}

		return MovieMapper.toDto(movie);
	}

	@Override
	public void deleteMovie(Long id) {
		movieRepository.deleteById(id);
	}

	@Override
	public MovieDto openLocation(Long id) {

		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Le Movie est introuvable"));


		// Vérification métier
		if(movie.isOuvertLocation()){
			throw new RuntimeException("Movie already ouvert for la location");
		}


		movie.setOuvertLocation(true);

		movie = movieRepository.save(movie);

		return MovieMapper.toDto(movie);
	}

	@Override
	public MovieDto closeLocation(Long id) {

		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Le Movie est absent dans la database"));

		if(!movie.isOuvertLocation()){
			throw new RuntimeException("Movie already fermé for la location");
		}


		movie.setOuvertLocation(false);

		movie = movieRepository.save(movie);

		return MovieMapper.toDto(movie);
	}
}