package com.awbd.proiect.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Name;

    @OneToMany(mappedBy = "genre")
    private List<Movie> movies;
}
