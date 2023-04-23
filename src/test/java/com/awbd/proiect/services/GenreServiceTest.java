package com.awbd.proiect.services;


import com.awbd.proiect.domain.Genre;
import com.awbd.proiect.repositories.GenreRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class GenreServiceTest {

    @Mock
    GenreRepository genreRepository;

    @InjectMocks
    GenreServiceImpl genreService;

    @Test
    public void findGenres() {
        List<Genre> genresRet = new ArrayList<Genre>();
        Genre genre = new Genre ();
        genre.setId(5000);
        genre.setName("Romance");
        genresRet.add(genre);

        when(genreRepository.findAll()).thenReturn(genresRet);
        List<Genre> genres = genreService.findAll();
        assertEquals(genres.size(), 1);
        verify(genreRepository, times(1)).findAll();
    }

}
