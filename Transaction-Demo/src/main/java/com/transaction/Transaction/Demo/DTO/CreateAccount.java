package com.transaction.Transaction.Demo.DTO;

import lombok.Data;

@Data
public class CreateAccount {

    private String name;
    private double amount;
    private String email;
}
