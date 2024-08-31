package com.transaction.Transaction.Demo.DTO;

import lombok.Data;

@Data
public class TransferRequestDTO {
    private String  receriver;
    private String sender;
    private  double amount;
}
