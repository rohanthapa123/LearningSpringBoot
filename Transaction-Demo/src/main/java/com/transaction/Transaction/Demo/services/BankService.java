package com.transaction.Transaction.Demo.services;

import com.transaction.Transaction.Demo.DTO.CreateAccount;
import com.transaction.Transaction.Demo.Repo.AccountRepository;
import com.transaction.Transaction.Demo.Repo.TransactionRepository;
import com.transaction.Transaction.Demo.model.Account;
import com.transaction.Transaction.Demo.model.Transaction;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Random;

@Service
public class BankService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final SendMailService sendMailService;
    private final SendMailAttachmentService sendMailAttachmentService;
    private final Random random;
    public BankService(AccountRepository accountRepository, TransactionRepository transactionRepository, SendMailService sendMailService, SendMailAttachmentService sendMailAttachmentService) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.sendMailService = sendMailService;
        this.sendMailAttachmentService = sendMailAttachmentService;
        this.random = new Random();
    }


    @Transactional(rollbackFor = Throwable.class)
    public void transferMoney(String sourceAccountNumber, String receiverAccountNumber, Double amount) throws Throwable {
        Account sourceAccount = (Account) accountRepository.findById(sourceAccountNumber)
                .orElseThrow(() -> new Throwable("Source Account Not Found"));

        Account receiverAccount = (Account) accountRepository.findById(receiverAccountNumber)
                .orElseThrow(() -> new Throwable("Receiver Account Not Found"));

        if (sourceAccount.getBalance() < amount) {
            throw new Throwable("Insufficient Balance");
        }

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        receiverAccount.setBalance(receiverAccount.getBalance() + amount);

        accountRepository.save(sourceAccount);
        accountRepository.save(receiverAccount);

        Transaction transaction = new Transaction(sourceAccountNumber, receiverAccountNumber, amount);
        transactionRepository.save(transaction);
    }

    public Account createAccount(CreateAccount createAccount) throws MessagingException {
        String accountNumber = generateAccount();
        Account account = new Account(accountNumber, createAccount.getName(), createAccount.getEmail(),createAccount.getAmount());
        String body = "Your otp is " + generateOtp();
        sendMailAttachmentService.sendMail(createAccount.getEmail(),body,"OTP validation");
        return accountRepository.save(account);
    }

    private String generateAccount(){

        StringBuilder accountNumber = new StringBuilder();

        for(int i = 0; i < 16 ; i++){
            int digit = random.nextInt(10);
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }

    private String generateOtp(){
        SecureRandom secureRandom = new SecureRandom();
        int otp = secureRandom.nextInt(900000) + 100000;
        return String.valueOf(otp);
    }
}
