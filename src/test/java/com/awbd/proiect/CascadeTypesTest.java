package com.awbd.proiect;

import com.awbd.proiect.domain.Actor;
import com.awbd.proiect.domain.Country;
import jakarta.persistence.EntityManager;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
@ActiveProfiles("mysql")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CascadeTypesTest {

    @Autowired
    private EntityManager entityManager;

    //@Ignore
    @Test
    public void SaveCountry() {

        Actor actor = new Actor();
        actor.setFirstName("Ann");
        actor.setLastName("Julian");

        Country country = new Country();
        country.setName("America");
        //country.setActors(Arrays.asList(actor));

        actor.setCountry(country);

        entityManager.persist(country);
        entityManager.flush();
        entityManager.clear();
    }
}
