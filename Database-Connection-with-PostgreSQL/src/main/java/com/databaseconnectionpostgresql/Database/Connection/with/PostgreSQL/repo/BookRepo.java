package com.databaseconnectionpostgresql.Database.Connection.with.PostgreSQL.repo;

import com.databaseconnectionpostgresql.Database.Connection.with.PostgreSQL.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
