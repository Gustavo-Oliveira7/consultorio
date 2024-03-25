package com.gustavo.consultorio.controller;


import com.gustavo.consultorio.dto.ClientDto;
import com.gustavo.consultorio.models.entities.Client;
import com.gustavo.consultorio.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDto> create(@RequestBody Client client) {
        Client newClient = clientService.create(client);
        ClientDto clientDto = new ClientDto(newClient.getName(),
                newClient.getCpf(), newClient.getBirthDate(),
                newClient.getAddress());
        return ResponseEntity.status(201).body(clientDto);
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients() {
        List<ClientDto> clients = clientService.getClients();
        return ResponseEntity.status(200).body(clients);
    }

    //getClientByCPF
    @GetMapping("/{cpf}")
    public ResponseEntity<Object> getClientByCpf(
            @PathVariable("cpf") String cpf
    ){
        try{
            Client client = clientService.getClientByCpf(cpf);
            ClientDto clientDto = new ClientDto(client.getName(),
                    client.getCpf(), client.getBirthDate(),
                    client.getAddress());
            return ResponseEntity.status(200).body(clientDto);

        } catch (RuntimeException error) {
            return ResponseEntity.status(404).body("Cpf nao encontrado");
        }
    }
}
