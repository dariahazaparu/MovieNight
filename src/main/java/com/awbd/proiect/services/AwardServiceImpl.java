package com.awbd.proiect.services;

import com.awbd.proiect.domain.Actor;
import com.awbd.proiect.domain.Award;
import com.awbd.proiect.repositories.AwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<Award> awards = new LinkedList<>();
        awards = awardRepository.findAll();
//        List<Actor> actors = actorService.findAll();
//        if (!awards.isEmpty())
//            for (Award a:awards) {
//                for (Actor ac: actors) {
//                    Award award = ac.getAwardById(ac);
//                    if (award != null && a == award && awards.contains(award)) {
//                        awards.remove(a);
//                    }
//                }
//            }
        return awards;
    }
}
