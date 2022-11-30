package com.example.demir_test.service;

import com.example.demir_test.model.entity.Account;
import com.example.demir_test.model.security.User;

public interface AccountService {

    Account createAccount(User user);
}
