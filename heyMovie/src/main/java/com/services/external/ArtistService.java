package com.services.external;

import com.dtos.ArtistDto;
import java.util.List;

public interface ArtistService {

    List<ArtistDto> getArtistsByMovie(String movieTitle);

    void addArtists(String movieTitle, List<ArtistDto> artists);
}