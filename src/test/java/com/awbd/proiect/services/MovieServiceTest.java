package com.awbd.proiect.services;

import com.awbd.proiect.domain.Movie;
import com.awbd.proiect.repositories.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@Slf4j
public class MovieServiceTest {
    @Mock
    MovieRepository movieRepository;

    @InjectMocks
    MovieServiceImpl movieService;

    @Test
    public void findMovies() {
        List<Movie> moviesRet = new ArrayList<>();

        Movie movie = new Movie();
        movie.setId(50000);
        movie.setName("Film");
        moviesRet.add(movie);

        log.info("findMovies");

        when(movieRepository.findAll()).thenReturn(moviesRet);
        List<Movie> movies = movieService.findAll();

        log.info(String.valueOf(movie.getId()));

        assertEquals(movies.size(), 1);
        verify(movieRepository, times(1)).findAll();

    }

    @Test
    public void findById_success() {
        Movie movieRet = new Movie();
        movieRet.setId(15000);
        movieRet.setName("Film");

        when(movieRepository.findById(15000L)).thenReturn(java.util.Optional.of(movieRet));
        Movie movie = movieService.findById(15000);
        assertEquals(movie.getName(), "Film");
        verify(movieRepository, times(1)).findById(15000L);
    }

    @Test
    public void findById_fail() {
        when(movieRepository.findById(1L)).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, ()->{movieService.findById(1L);});
        log.info("findById exception");
        verify(movieRepository, times(1)).findById(1L);
    }
}
