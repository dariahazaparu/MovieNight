package com.awbd.proiect.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Name;
    private int Year;

    @OneToOne(mappedBy = "award", cascade = CascadeType.ALL, orphanRemoval = true)
    private Actor actor;

}
