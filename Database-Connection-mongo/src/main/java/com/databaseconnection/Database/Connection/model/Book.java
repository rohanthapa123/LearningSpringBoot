package com.databaseconnection.Database.Connection.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection  = "books")
public class Book {

    @Id
    private String id;
    private String name;
    private String author;
    private double price;

}
