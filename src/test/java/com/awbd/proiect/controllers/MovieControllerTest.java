package com.awbd.proiect.controllers;

import com.awbd.proiect.domain.Movie;
import com.awbd.proiect.services.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class MovieControllerTest {

    @Mock
    Model model;

    @Mock
    MovieService movieService;

    MovieController movieController;


    @BeforeEach
    public void setUp() throws Exception {
        movieController = new MovieController(movieService);
    }

    @Test
    public void showById() {
        Long id = 1l;
        Movie movieTest = new Movie();
        movieTest.setId(id);

        when(movieService.findById(id)).thenReturn(movieTest);

        String viewName = movieController.getById(id.toString(), model);
        assertEquals("movieDetails", viewName);
        verify(movieService, times(1)).findById(id);

        ArgumentCaptor<Movie> argumentCaptor = ArgumentCaptor.forClass(Movie.class);
        verify(model, times(1))
                .addAttribute(eq("movie"), argumentCaptor.capture() );

        Movie movieArg = argumentCaptor.getValue();
        assertEquals(movieArg.getId(), movieTest.getId() );

    }
}
