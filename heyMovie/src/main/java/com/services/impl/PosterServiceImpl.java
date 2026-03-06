package com.services.impl;

import com.services.external.PosterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

@Service
@RequiredArgsConstructor
public class PosterServiceImpl implements PosterService {

    private final RestTemplate restTemplate;

    private final String POSTER_API_URL =
            "http://localhost:12005/posters/";

    @Override
    public byte[] getPoster(String movieTitle) {

        String url = POSTER_API_URL + movieTitle;

        try {
            return restTemplate.getForObject(url, byte[].class);
        }
        catch (RestClientException e) {

            System.out.println("Poster API indisponible pour : " + movieTitle);

            return null; // pas de poster mais le film reste chargé
        }
    }

    @Override
    public void uploadPoster(String movieTitle, byte[] poster) {

        String url = POSTER_API_URL + movieTitle;

        try {
            restTemplate.postForObject(url, poster, Void.class);
        }
        catch (RestClientException e) {

            System.out.println("Impossible d'uploader le poster : " + movieTitle);
        }
    }
}