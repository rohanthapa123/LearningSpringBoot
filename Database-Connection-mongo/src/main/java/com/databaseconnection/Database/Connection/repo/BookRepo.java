package com.databaseconnection.Database.Connection.repo;

import com.databaseconnection.Database.Connection.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends MongoRepository<Book , String> {

}
