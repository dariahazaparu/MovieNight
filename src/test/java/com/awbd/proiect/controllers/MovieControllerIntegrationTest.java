package com.awbd.proiect.controllers;

import com.awbd.proiect.domain.Genre;
import com.awbd.proiect.domain.Movie;
import com.awbd.proiect.services.MovieService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MovieService movieService;

    @MockBean
    Model model;

    @Before

    @Test
    public void showByIdMVC() throws Exception {
        mockMvc.perform(get("/movies/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("movieDetails"));
    }
    @Test
    @WithMockUser(username = "guest", password = "12345", roles = "GUEST")
    public void getByIdMockMvc() throws Exception {
        Long id = 1l;
        Movie productTest = new Movie();
        productTest.setId(id);
        productTest.setName("test");

        Genre genre = new Genre();
        genre.setId(1);
        genre.setName("genre");

        productTest.setGenre(genre);

        when(movieService.findById(id)).thenReturn(productTest);

        mockMvc.perform(get("/movies/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("movieDetails"))
                .andExpect(model().attribute("movie", productTest))
                .andExpect(content().contentType("text/html;charset=UTF-8"));;
    }
}
