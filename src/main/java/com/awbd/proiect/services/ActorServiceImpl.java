package com.awbd.proiect.services;

import com.awbd.proiect.domain.Actor;
import com.awbd.proiect.exceptions.ResourceNotFoundException;
import com.awbd.proiect.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService{
    ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        List<Actor> actors = new LinkedList<>();
        actors = actorRepository.findAll();
        return actors;
    }

    @Override
    public Actor findById(long id) {
        Optional<Actor> actor = actorRepository.findById(id);
        if (actor.isEmpty()) {
            throw new ResourceNotFoundException("Actor not found");
        }
        return actor.get();
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public void deleteById(long id) {
        actorRepository.deleteById(id);
    }
}
