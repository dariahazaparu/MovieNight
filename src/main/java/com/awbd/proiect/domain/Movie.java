package com.awbd.proiect.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Name;

    @ManyToOne
    private Genre genre;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="actor_movie",
            joinColumns = @JoinColumn(name="movie_id", referencedColumnName = "Id"),
            inverseJoinColumns = @JoinColumn(name="actor_id", referencedColumnName = "Id"))
    private List<Actor> actors;
}
