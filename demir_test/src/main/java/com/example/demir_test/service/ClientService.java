package com.example.demir_test.service;

import com.example.demir_test.payload.client.ClientRequest;
import com.example.demir_test.payload.client.ClientResponse;

public interface ClientService {

    ClientResponse registration(ClientRequest request);
}
