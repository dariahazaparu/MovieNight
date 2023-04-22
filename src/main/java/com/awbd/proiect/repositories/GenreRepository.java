package com.awbd.proiect.repositories;

import com.awbd.proiect.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    void deleteById(Long id);
    Genre save(Genre product);
}
