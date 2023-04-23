package com.awbd.proiect.services;

import com.awbd.proiect.domain.Actor;
import com.awbd.proiect.domain.Award;
import com.awbd.proiect.repositories.AwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class AwardServiceImpl implements AwardService {
    AwardRepository awardRepository;

    @Autowired
    ActorService actorService;

    @Autowired
    public AwardServiceImpl(AwardRepository awardRepository) {
        this.awardRepository = awardRepository;
    }

    @Override
    public List<Award> findAll() {
        List<Award> awards = new ArrayList<>();
        awards = awardRepository.findAll();
        List<Award> finalAwards = awards;

        List<Actor> actors = actorService.findAll();
        if (!awards.isEmpty()) {
            actors.forEach((ac) -> {
                Award a = actorService.getAwardById(ac);
                if (finalAwards.contains(a)){
                    finalAwards.remove(a);
                }

            });
        }
//                for (Actor ac: actors) {
//                    long x = 5L;
//                    Award award = actorService.getAwardById(ac);
//                    if (award != null && awards.contains(award)) {
//                        awards.remove(award);
//                    }
//                }
        return finalAwards;
    }
}
