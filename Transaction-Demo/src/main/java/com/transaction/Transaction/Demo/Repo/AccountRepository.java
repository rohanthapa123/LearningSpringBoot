package com.transaction.Transaction.Demo.Repo;

import com.transaction.Transaction.Demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

}
