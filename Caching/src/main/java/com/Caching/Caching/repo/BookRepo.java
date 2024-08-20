package com.Caching.Caching.repo;

import com.Caching.Caching.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookRepo extends JpaRepository<Book , Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.Author = ?1 WHERE b.id = ?2")
    int updateBookAuthor(String Author, Long id);
}
