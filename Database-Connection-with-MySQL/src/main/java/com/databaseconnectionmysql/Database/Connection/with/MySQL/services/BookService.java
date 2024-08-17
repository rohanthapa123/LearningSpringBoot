package com.databaseconnectionmysql.Database.Connection.with.MySQL.services;

import com.databaseconnectionmysql.Database.Connection.with.MySQL.model.Book;
import com.databaseconnectionmysql.Database.Connection.with.MySQL.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    public Book insertBook(Book book){
        return bookRepo.save(book);
    }

    public Optional<Book> getBookById(Long id){
        return bookRepo.findById(id);
    }

    public void deleteBookById(Long id){
        bookRepo.deleteById(id);
    }
}
