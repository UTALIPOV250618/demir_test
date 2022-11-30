package com.example.demir_test.payload.balance;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionResponse {

    private Long userId;
    private double balance;

    public TransactionResponse() {

    }

    public TransactionResponse(Long userId, double balance) {
        this.userId = userId;
        this.balance = balance;
    }
}
