package com.practice.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "ob_cars")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;

    private Double cc;
    @Column(name = "release_year")
    private Integer releaseYear;
}
