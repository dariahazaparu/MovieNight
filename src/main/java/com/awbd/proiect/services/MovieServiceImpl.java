package com.awbd.proiect.services;

import com.awbd.proiect.domain.Genre;
import com.awbd.proiect.domain.Movie;
import com.awbd.proiect.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        List<Movie> movies = new LinkedList<>();
        movieRepository.findAll().iterator().forEachRemaining(movies::add);
        return movies;
    }

    @Override
    public Movie findById(long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (!movieOptional.isPresent()) {
            throw new RuntimeException("Movie not found!");
        }
        return movieOptional.get();
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteById(long id) {
        movieRepository.deleteById(id);
    }
}
