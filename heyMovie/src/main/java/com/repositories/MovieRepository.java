package com.repositories;

import com.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}