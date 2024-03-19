package com.gustavo.consultorio.controller;


import com.gustavo.consultorio.dto.ClientDto;
import com.gustavo.consultorio.models.entities.Client;
import com.gustavo.consultorio.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDto> create(@RequestBody Client client) {
        Client newClient = clientService.create(client);
        ClientDto clientDto = new ClientDto(newClient.getCpf(),
                newClient.getAddress(), newClient.getBirthDate(),
                newClient.getName());
        return ResponseEntity.status(201).body(clientDto);
    }
}
