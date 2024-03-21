package com.gustavo.consultorio.service;

import com.gustavo.consultorio.dto.ClientDto;
import com.gustavo.consultorio.models.entities.Client;
import com.gustavo.consultorio.models.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public List<ClientDto> getClients(){
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(client -> new ClientDto(
                client.getName(),
                client.getCpf(),
                client.getBirthDate(),
                client.getAddress()
        )).collect(Collectors.toList());
    }
}
