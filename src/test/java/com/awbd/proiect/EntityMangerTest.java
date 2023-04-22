package com.awbd.proiect;

import com.awbd.proiect.domain.Genre;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("h2")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
public class EntityMangerTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void findGenre() {
        Genre genreFound = entityManager.find(Genre.class, 1L);
        Assertions.assertEquals(genreFound.getName(), "Action");
    }

    @Test
    public void UpdateGenre() {

        Genre genreFound = entityManager.find(Genre.class, 1L);
        genreFound.setName("Thriller");

        entityManager.persist(genreFound);

        genreFound = entityManager.find(Genre.class, 1L);
        assertEquals("Thriller", genreFound.getName());

        entityManager.flush();
    }
}
