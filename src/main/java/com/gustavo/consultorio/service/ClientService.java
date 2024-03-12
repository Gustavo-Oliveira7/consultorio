package com.gustavo.consultorio.service;

import com.gustavo.consultorio.models.entities.Client;
import com.gustavo.consultorio.models.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client create(Client client) {
        return clientRepository.save(client);
    }
}
