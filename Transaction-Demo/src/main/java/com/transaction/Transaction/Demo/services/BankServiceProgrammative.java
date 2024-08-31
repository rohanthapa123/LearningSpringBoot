//package com.transaction.Transaction.Demo.services;
//
//import com.transaction.Transaction.Demo.Repo.AccountRepository;
//import com.transaction.Transaction.Demo.Repo.TransactionRepository;
//import com.transaction.Transaction.Demo.model.Account;
//import com.transaction.Transaction.Demo.model.Transaction;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.support.TransactionTemplate;
//
//@Service
//public class BankServiceProgrammative {
//    private final TransactionTemplate transactionTemplate;
//    private final AccountRepository accountRepository;
//    private final TransactionRepository transactionRepository;
//
//    public BankServiceProgrammative(PlatformTransactionManager transactionManager,
//                                    AccountRepository accountRepository,
//                                    TransactionRepository transactionRepository) {
//        this.transactionTemplate = new TransactionTemplate(transactionManager);
//        this.accountRepository = accountRepository;
//        this.transactionRepository = transactionRepository;
//    }
//
//    public void transferMoney(String sourceAccountNumber, String destinationAccountNumber, Double amount) {
//        transactionTemplate.execute(status -> {
//            try {
//                Account sourceAccount = (Account) accountRepository.findById(sourceAccountNumber)
//                        .orElseThrow(() -> new RuntimeException("Source account not found"));
//                Account destinationAccount = (Account) accountRepository.findById(destinationAccountNumber)
//                        .orElseThrow(() -> new RuntimeException("Destination account not found"));
//
//                if (sourceAccount.getBalance() < amount) {
//                    throw new RuntimeException("Insufficient funds");
//                }
//
//                sourceAccount.setBalance(sourceAccount.getBalance() - amount);
//                destinationAccount.setBalance(destinationAccount.getBalance() + amount);
//
//                accountRepository.save(sourceAccount);
//                accountRepository.save(destinationAccount);
//
//                Transaction transaction = new Transaction(sourceAccountNumber, destinationAccountNumber, amount);
//                transactionRepository.save(transaction);
//
//                return null;  // Return null as per the TransactionCallback<Void> signature
//            } catch (Throwable e) {
//                status.setRollbackOnly();
//                throw new RuntimeException(e);
//            }
//        });
//    }
//}
