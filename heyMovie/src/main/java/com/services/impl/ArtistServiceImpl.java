package com.services.impl;

import com.dtos.ArtistDto;
import com.services.external.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final RestTemplate restTemplate;

    private final String ARTIST_API_URL =
            "http://localhost:12103/artists/";

    @Override
    public List<ArtistDto> getArtistsByMovie(String movieTitle) {

        try {

            String url = ARTIST_API_URL + movieTitle;

            ArtistDto[] artists =
                    restTemplate.getForObject(url, ArtistDto[].class);

            if (artists == null) {
                return Collections.emptyList();
            }

            return Arrays.asList(artists);

        } catch (RestClientException e) {

            System.out.println("Artist API indisponible : " + e.getMessage());

            return Collections.emptyList();

        }
    }

    @Override
    public void addArtists(String movieTitle, List<ArtistDto> artists) {

        try {

            String url = ARTIST_API_URL + movieTitle;

            restTemplate.postForObject(url, artists, Void.class);

        } catch (RestClientException e) {

            System.out.println("Impossible d'ajouter les artistes : " + e.getMessage());

        }

    }
}