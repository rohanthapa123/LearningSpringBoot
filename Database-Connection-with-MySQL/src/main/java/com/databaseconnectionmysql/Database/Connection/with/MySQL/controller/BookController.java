package com.databaseconnectionmysql.Database.Connection.with.MySQL.controller;

import com.databaseconnectionmysql.Database.Connection.with.MySQL.model.Book;
import com.databaseconnectionmysql.Database.Connection.with.MySQL.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @PostMapping("/book")
    public Book insertBook(@RequestBody Book book){
        return  bookService.insertBook(book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBookById(@PathVariable Long id){
        bookService.deleteBookById(id);
    }
}
