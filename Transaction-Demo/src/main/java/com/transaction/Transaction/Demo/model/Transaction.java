package com.transaction.Transaction.Demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceAccount;
    private String destinationAccount;

    private double amount;

    public Transaction(String sourceAccountNumber, String receiverAccountNumber, Double amount) {
        this.sourceAccount = sourceAccountNumber;
        this.destinationAccount = receiverAccountNumber;
        this.amount = amount;
    }
}
