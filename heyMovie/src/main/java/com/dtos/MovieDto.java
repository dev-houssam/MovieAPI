package com.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovieDto {
	
	@NotNull
	private Long id;
	
	@NotBlank(message = "Le titre est obligatoire")
	private String titre;
	
	@NotBlank(message = "La genre est obligatoire")
	private String genre;
	
}
