package com.awbd.proiect.services;

import com.awbd.proiect.domain.Actor;
import com.awbd.proiect.domain.Actor;
import com.awbd.proiect.repositories.ActorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@Slf4j
public class ActorServiceTest {

    @Mock
    ActorRepository actorRepository;

    @InjectMocks
    ActorServiceImpl actorService;

    @Test
    public void findActors() {
        List<Actor> actorsRet = new ArrayList<>();

        Actor actor = new Actor();
        actor.setId(100);
        actor.setFirstName("firstname");
        actor.setLastName("lastname");
        actorsRet.add(actor);

        log.info("findActors");
        log.info(actor.getFirstName() + actor.getLastName());

        when(actorRepository.findAll()).thenReturn(actorsRet);
        List<Actor> actors = actorService.findAll();
        assertEquals(actors.size(), 1);
        verify(actorRepository, times(1)).findAll();
    }

    @Test
    public void findById_success() {
        Actor actorRet = new Actor();
        actorRet.setId(15000);
        actorRet.setFirstName("First");
        actorRet.setLastName("Last");

        log.info("findById");

        when(actorRepository.findById(15000L)).thenReturn(java.util.Optional.of(actorRet));
        Actor actor = actorService.findById(15000);

        log.info(String.valueOf(actorRet.getId()));

        assertEquals(actor.getFirstName(), "First");
        verify(actorRepository, times(1)).findById(15000L);
    }

    @Test
    public void findById_fail() {
        when(actorRepository.findById(1L)).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, ()->{actorService.findById(1L);});
        log.info("findById exception");
        verify(actorRepository, times(1)).findById(1L);
    }
}
