package com.awbd.proiect.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Message;

    @ManyToOne
    private Movie movie;

    @Enumerated(value = EnumType.STRING)
    private Rating rating;
}
