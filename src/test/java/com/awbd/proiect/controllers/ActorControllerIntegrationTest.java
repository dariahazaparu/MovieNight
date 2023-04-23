package com.awbd.proiect.controllers;

import com.awbd.proiect.domain.Country;
import com.awbd.proiect.domain.Genre;
import com.awbd.proiect.domain.Actor;
import com.awbd.proiect.services.ActorService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@ActiveProfiles("h2")
public class ActorControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ActorService ActorService;

    @MockBean
    Model model;

    @Test
    public void showByIdMVC() throws Exception {

        mockMvc.perform(get("/actors/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("actorDetails"));
    }


    @Test
    @WithMockUser(username = "guest", password = "12345", roles = "GUEST")
    public void showByIdNotFound() throws Exception {

        mockMvc.perform(get("/actors/{id}", "17"))
                .andExpect(status().isNotFound())
                .andExpect(view().name("notFoundException"));
    }


    @Test
    @WithMockUser(username = "guest", password = "12345", roles = "GUEST")
    public void getByIdMockMvc() throws Exception {
        Long id = 1l;
        Actor productTest = new Actor();
        productTest.setId(id);
        productTest.setFirstName("test");

        Country genre = new Country();
        genre.setId(1);
        genre.setName("genre");
        productTest.setCountry(genre);

        log.info("add Actor...");
        when(ActorService.findById(id)).thenReturn(productTest);

        mockMvc.perform(get("/actors/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("actorDetails"))
                .andExpect(model().attribute("actor", productTest))
                .andExpect(content().contentType("text/html;charset=UTF-8"));;
    }
}

