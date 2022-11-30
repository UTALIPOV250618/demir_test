package com.example.demir_test.mapper.client;

import com.example.demir_test.model.security.Role;
import com.example.demir_test.model.security.User;
import com.example.demir_test.payload.client.ClientRequest;
import com.example.demir_test.repo.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ClientEditMapper {

    private final RoleRepository roleRepository;

    public User createUser(ClientRequest userRequest) {
        if (userRequest == null) {
            return null;
        }
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(user.getPassword());
        user.setCreated(LocalDateTime.now());
        user.setActive(true);

        List<Role> roles = new ArrayList<>();
        Role role = roleRepository.findById(2L).get();
        roles.add(role);
        user.setRoles(roles);
        return user;
    }

    public User updateUser(User user, ClientRequest userRequest) {

        user.setUsername(userRequest.getUsername());
        user.setPassword(user.getPassword());
        user.setCreated(LocalDateTime.now());
        user.setActive(true);
        return user;
    }
}

