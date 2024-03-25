package com.gustavo.consultorio.service;

import com.gustavo.consultorio.dto.ClientDto;
import com.gustavo.consultorio.models.entities.Client;
import com.gustavo.consultorio.models.repositories.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
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

    public Client getClientByCpf(String cpf){
        Optional<Client> client = Optional.ofNullable(clientRepository.findByCpf(cpf));
        if (client.isEmpty()) {
            throw new RuntimeException();
        }
        return client.get();
    }


}
