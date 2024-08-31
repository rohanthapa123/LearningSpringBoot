package com.transaction.Transaction.Demo.Repo;

import com.transaction.Transaction.Demo.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction , Long> {
}
