package com.example.demir_test.service;

import com.example.demir_test.payload.balance.TransactionResponse;

public interface TransactionService {

    TransactionResponse createTransactions(Long userId);
}
