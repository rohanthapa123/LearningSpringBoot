package com.Caching.Caching.services;

import com.Caching.Caching.model.Book;
import com.Caching.Caching.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }

    @Cacheable("books")
    public List<Book> getBooks(){
        System.out.println("Fetching from DB");
        return bookRepo.findAll();
    }

    @Cacheable(cacheNames = "books" , key = "#id")
    public Optional<Book> getBookById(Long id){
        return bookRepo.findById(id);
    }

   public Book insertBook(Book book){
        return bookRepo.save(book);
    }

    @CachePut(cacheNames = "books" , key = "#book.id")
    public Book updateBook(Book book){
        bookRepo.updateBookAuthor(book.getAuthor() , book.getId());
        return book;
    }

    @CacheEvict(cacheNames = "books" , key = "#id")
    public void deleteBookById(Long id){
        bookRepo.deleteById(id);
    }

}
