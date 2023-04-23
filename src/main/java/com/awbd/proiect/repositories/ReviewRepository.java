package com.awbd.proiect.repositories;

import com.awbd.proiect.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("select p from Review p where p.movie.id = ?1")
    List<Review> findByMovie(long id);
//movie parametru

    void deleteById(Long id);
    Review save(Review review);
}
