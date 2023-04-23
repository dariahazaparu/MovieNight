package com.awbd.proiect.controllers;

import com.awbd.proiect.domain.Actor;

import com.awbd.proiect.services.ActorService;
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
public class ActorControllerTest {

    @Mock
    Model model;

    @Mock
    ActorService actorService;

    ActorController actorController;


    @BeforeEach
    public void setUp() throws Exception {
        actorController = new ActorController(actorService);
    }

    @Test
    public void showById() {
        Long id = 1l;
        Actor actorTest = new Actor();
        actorTest.setId(id);

        when(actorService.findById(id)).thenReturn(actorTest);

        String viewName = actorController.getById(id.toString(), model);
        assertEquals("actorDetails", viewName);
        verify(actorService, times(1)).findById(id);

        ArgumentCaptor<Actor> argumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(model, times(1))
                .addAttribute(eq("actor"), argumentCaptor.capture() );

        Actor actorArg = argumentCaptor.getValue();
        assertEquals(actorArg.getId(), actorTest.getId() );

    }


}
