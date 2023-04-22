package com.awbd.proiect.services;

import com.awbd.proiect.domain.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(long id);
    Movie save(Movie movie);
    void deleteById(long id);

}
