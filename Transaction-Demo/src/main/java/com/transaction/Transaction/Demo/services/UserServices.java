package com.transaction.Transaction.Demo.services;

import com.transaction.Transaction.Demo.Repo.AccountRepository;
import com.transaction.Transaction.Demo.model.Account;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServices {
    private final AccountRepository accountRepository;

    public UserServices(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Map<String, Object> getUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder){

        Sort.Direction direction = "desc".equalsIgnoreCase(sortOrder) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction,sortBy));
        Page<Account> pageAccounts = accountRepository.findAll(pageable);

        Map<String,Object> response = new HashMap<>();
        response.put("items", pageAccounts.getContent());
        response.put("currentPage", pageAccounts.getNumber());
        response.put("totalItems", pageAccounts.getTotalElements());
        response.put("totalPages", pageAccounts.getTotalPages());
        response.put("pageSize", pageAccounts.getSize());

        return response;
    }
}
