package com.transaction.Transaction.Demo.controller;

import com.transaction.Transaction.Demo.DTO.CreateAccount;
import com.transaction.Transaction.Demo.DTO.TransferRequestDTO;
import com.transaction.Transaction.Demo.model.Account;
import com.transaction.Transaction.Demo.services.BankService;
import com.transaction.Transaction.Demo.services.SendMailService;
import jakarta.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    private BankService bankService;

    public BankController(BankService bankService){
        this.bankService = bankService;
    }

    @PostMapping("/account")
    public ResponseEntity<Account> createAccount(@RequestBody CreateAccount createAccount) throws MessagingException {

        Account acc = bankService.createAccount(createAccount);
        return new ResponseEntity<>(acc, HttpStatus.OK);

    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferBalance(@RequestBody TransferRequestDTO transferRequest){
        try {
            bankService.transferMoney(transferRequest.getSender(), transferRequest.getReceriver(), transferRequest.getAmount());
            return new ResponseEntity<>("Balance Transfered Success", HttpStatus.OK);
        }catch (Throwable e){
            return  new ResponseEntity<>("Error occured", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
