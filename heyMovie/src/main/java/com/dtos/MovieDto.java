package com.dtos;

import lombok.*;

import java.util.List;
import java.util.Set;

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