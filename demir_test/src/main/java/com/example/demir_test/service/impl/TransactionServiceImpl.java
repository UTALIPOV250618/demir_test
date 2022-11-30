package com.example.demir_test.service.impl;


import com.example.demir_test.model.entity.Account;
import com.example.demir_test.model.entity.Transactions;
import com.example.demir_test.payload.balance.TransactionResponse;
import com.example.demir_test.repo.AccountRepository;
import com.example.demir_test.repo.TransactionsRepository;
import com.example.demir_test.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionsRepository transactionsRepository;


    @Override
    public TransactionResponse createTransactions(Long userId) {

        Account account = accountRepository.findByUserId(userId).orElseThrow(()->new RuntimeException("Account by user ID " + userId + " not found"));
        double subtractedAmount = account.getBalance()-1.1;
        account.setBalance(subtractedAmount);
        Transactions transactions = new Transactions();
        transactions.setAccount(account);
        transactions.setSumOut(1.1);
        transactions.setAmount(subtractedAmount);
        transactions.setDate(LocalDateTime.now());
        List<Transactions> transactionsList = new ArrayList<>();
        transactionsList.add(transactions);
        account.setTransactions(transactionsList);
        transactionsRepository.save(transactions);

        return new TransactionResponse(transactions.getId(),transactions.getAmount());
    }
}
