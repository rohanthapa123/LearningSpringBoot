package com.databaseconnectionpostgresql.Database.Connection.with.PostgreSQL.services;

import com.databaseconnectionpostgresql.Database.Connection.with.PostgreSQL.model.Book;
import com.databaseconnectionpostgresql.Database.Connection.with.PostgreSQL.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices {

    @Autowired
    private BookRepo bookRepo;

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return bookRepo.findById(id);
    }
    public Book insertBook(Book book){
        return bookRepo.save(book);
    }
    public void deleteBookById(Long id){
        bookRepo.deleteById(id);
    }
}
