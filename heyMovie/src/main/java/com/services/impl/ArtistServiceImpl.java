package com.services.impl;

import com.dtos.ArtistDto;
import com.services.external.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final RestTemplate restTemplate;

    private final String ARTIST_API_URL =
            "http://localhost:12100/artists/";

    @Override
    public List<ArtistDto> getArtistsByMovie(String movieTitle) {

        String url = ARTIST_API_URL + movieTitle;

        ArtistDto[] artists =
                restTemplate.getForObject(url, ArtistDto[].class);

        return Arrays.asList(artists);
    }

    @Override
    public void addArtists(String movieTitle, List<ArtistDto> artists) {

        String url = ARTIST_API_URL + movieTitle;

        restTemplate.postForObject(url, artists, Void.class);
    }
}