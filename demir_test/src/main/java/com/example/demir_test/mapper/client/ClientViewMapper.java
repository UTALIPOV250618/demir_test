package com.example.demir_test.mapper.client;

import com.example.demir_test.model.security.Role;
import com.example.demir_test.model.security.User;
import com.example.demir_test.payload.client.ClientResponse;
import com.example.demir_test.repo.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ClientViewMapper {

    private final RoleRepository roleRepository;

    public ClientResponse viewUser(User user) {
        if (user == null) {
            return null;
        }
        ClientResponse response = new ClientResponse();
        if (user.getId() != null) {
            response.setId(Long.valueOf(user.getId()));
        }
        response.setUsername(user.getUsername());
        response.setCreated(user.getCreated());
        response.setActive(true);
        return response;
    }

    public List<ClientResponse> viewClients() {
        List<ClientResponse> clients = new ArrayList<>();
        Role role = roleRepository.findById(2L).get();
        for (User client : role.getUsers()) {
            clients.add(viewUser(client));
        }
        return clients;
    }
}
