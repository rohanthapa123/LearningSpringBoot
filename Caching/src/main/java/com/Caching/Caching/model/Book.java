package com.Caching.Caching.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "myBook")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String Author;

    private double price;
}
