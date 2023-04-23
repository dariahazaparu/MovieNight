package com.awbd.proiect.services;

import com.awbd.proiect.domain.Award;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AwardService {
//    @Query("select a.* from award a left join actor ac\n" +
//            "on ac.award_id = a.id\n" +
//            "where ac.award_id is null")
    List<Award> findAll();
}
