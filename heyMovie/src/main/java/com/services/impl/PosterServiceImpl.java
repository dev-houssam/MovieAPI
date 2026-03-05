package com.services.impl;

import com.services.external.PosterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
//probleme : Class 'PosterServiceImpl' is public, should be declared in a file named 'PosterServiceImpl.java'
public class PosterServiceImpl implements PosterService {

    private final RestTemplate restTemplate;

    private final String POSTER_API_URL =
            "http://localhost:12100/posters/";

    @Override
    public byte[] getPoster(String movieTitle) {

        String url = POSTER_API_URL + movieTitle;

        return restTemplate.getForObject(url, byte[].class);
    }

    @Override
    public void uploadPoster(String movieTitle, byte[] poster) {

        String url = POSTER_API_URL + movieTitle;

        restTemplate.postForObject(url, poster, Void.class);
    }
}