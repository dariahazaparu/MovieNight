package com.awbd.proiect.repositories;

import com.awbd.proiect.domain.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardRepository extends JpaRepository<Award, Long> {
}
