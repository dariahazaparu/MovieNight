package com.awbd.proiect.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String FirstName;
    private String LastName;

    @OneToOne
    private Award award;

    @ManyToMany(mappedBy = "actors",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Movie> movies;

    @ManyToOne
    private Country country;
}
