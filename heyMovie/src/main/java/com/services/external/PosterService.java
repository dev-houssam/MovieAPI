package com.services.external;

import org.springframework.stereotype.Service;


public interface PosterService {

    byte[] getPoster(String movieTitle);

    void uploadPoster(String movieTitle, byte[] poster);
}