package com.awbd.proiect.repositories;

import com.awbd.proiect.domain.Actor;
import com.awbd.proiect.domain.Genre;
import com.awbd.proiect.domain.Movie;
import com.awbd.proiect.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    //@Query("select m from Movie where m.Genre.Id = ?1")
    List<Genre> findByGenre (Long actorId);
}
