package com.dtos;

import com.entities.Movie;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreDto {

    private Long id;
    private String titre;
    private Set<Movie> movies;
}