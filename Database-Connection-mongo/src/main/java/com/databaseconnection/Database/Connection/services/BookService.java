package com.databaseconnection.Database.Connection.services;

import com.databaseconnection.Database.Connection.model.Book;
import com.databaseconnection.Database.Connection.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    public Book insertBook(Book book) {
        return bookRepo.save(book);
    }
}
