package com.Caching.Caching.controller;

import com.Caching.Caching.model.Book;
import com.Caching.Caching.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Optional<Book>> getBookByID(@PathVariable Long id){
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<Book> insertBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.insertBook(book), HttpStatus.OK);
    }

    @PutMapping("/book")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBookByID(@PathVariable Long id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>("Book Deleted Success" , HttpStatus.OK);
    }
}
