package com.awbd.proiect.services;

import com.awbd.proiect.domain.Actor;
import com.awbd.proiect.domain.Award;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();
    Actor findById(long id);
    Actor save(Actor actor);
    void deleteById(long id);
    Award getAwardById(long id);
}
