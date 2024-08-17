package com.databaseconnection.Database.Connection.controller;

import com.databaseconnection.Database.Connection.model.Book;
import com.databaseconnection.Database.Connection.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @PostMapping("/book")
    public Book insetBook(@RequestBody Book book){
        return bookService.insertBook(book);
    }
}
