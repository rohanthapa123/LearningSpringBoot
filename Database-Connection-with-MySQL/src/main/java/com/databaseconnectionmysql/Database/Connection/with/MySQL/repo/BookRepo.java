package com.databaseconnectionmysql.Database.Connection.with.MySQL.repo;

import com.databaseconnectionmysql.Database.Connection.with.MySQL.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book , Long> {
}
