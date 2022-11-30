package com.example.demir_test.mapper.auth;

import com.example.demir_test.model.security.Role;
import com.example.demir_test.model.security.User;
import com.example.demir_test.payload.auth.AuthResponse;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class AuthMapper {

    public AuthResponse view(String token, String message, User user) {
        AuthResponse authResponse = new AuthResponse();
        if (user != null) {
            setAuthority(authResponse, user.getRoles());
        }
        authResponse.setJwtToken(token);
        authResponse.setUsername(user.getUsername());
        authResponse.setMessage(message);
        authResponse.setCreated(LocalDateTime.now());
        return authResponse;
    }

    private void setAuthority(AuthResponse authResponse, List<Role> roles) {
        Set<String> authorities = new HashSet<>();
        for (Role role : roles) {
            authorities.add(role.getName());
        }
        authResponse.setAuthorities(authorities);
    }
}
