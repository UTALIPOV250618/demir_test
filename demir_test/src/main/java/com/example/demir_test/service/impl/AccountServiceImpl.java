package com.example.demir_test.service.impl;

import com.example.demir_test.model.entity.Account;
import com.example.demir_test.model.security.User;
import com.example.demir_test.repo.AccountRepository;
import com.example.demir_test.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;


    @Override
    public Account createAccount(User user) {

        Account account = new Account();
        account.setBalance(8.0);
        account.setUser(user);
        accountRepository.save(account);
        return account;
    }
}
