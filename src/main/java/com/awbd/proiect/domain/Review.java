package com.awbd.proiect.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Length(max = 120)
    private String Message;

    @ManyToOne
    private Movie movie;

    @Enumerated(value = EnumType.STRING)
    private Rating rating;
}
