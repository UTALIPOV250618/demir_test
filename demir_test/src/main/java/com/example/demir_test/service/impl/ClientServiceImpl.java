package com.example.demir_test.service.impl;


import com.example.demir_test.mapper.client.ClientEditMapper;
import com.example.demir_test.mapper.client.ClientViewMapper;
import com.example.demir_test.model.entity.Account;
import com.example.demir_test.model.security.User;
import com.example.demir_test.payload.client.ClientRequest;
import com.example.demir_test.payload.client.ClientResponse;
import com.example.demir_test.repo.UserRepository;
import com.example.demir_test.service.ClientService;
import com.example.demir_test.service.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ClientServiceImpl implements UserDetailsService, ClientService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ClientEditMapper editMapper;
    private final ClientViewMapper viewMapper;
    private final AccountServiceImpl accountService;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("username not found"));
    }

    public ClientResponse registration(ClientRequest request) {
        User user = editMapper.createUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setActive(true);
        Account balance = accountService.createAccount(user);
        user.setAccount(balance);
        repository.save(user);
        log.info("Client has successfully registered: {}", user.getUsername());
        return viewMapper.viewUser(user);
    }


}
