package com.databaseconnectionpostgresql.Database.Connection.with.PostgreSQL.controller;

import com.databaseconnectionpostgresql.Database.Connection.with.PostgreSQL.model.Book;
import com.databaseconnectionpostgresql.Database.Connection.with.PostgreSQL.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookServices bookServices;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookServices.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getAllBooks(@PathVariable Long id){
        return bookServices.getBookById(id);
    }


    @PostMapping("/book")
    public Book getAllBooks(@RequestBody Book book){
        return bookServices.insertBook(book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBookById(@PathVariable Long id){
        bookServices.deleteBookById(id);
    }
}
