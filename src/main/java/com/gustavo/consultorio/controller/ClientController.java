package com.gustavo.consultorio.controller;


import com.gustavo.consultorio.dto.ClientDto;
import com.gustavo.consultorio.dto.DoctorDto;
import com.gustavo.consultorio.models.entities.Client;
import com.gustavo.consultorio.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
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
        ClientDto clientDto = new ClientDto(newClient.getCpf(),
                newClient.getAddress(), newClient.getBirthDate(),
                newClient.getName());
        return ResponseEntity.status(201).body(clientDto);
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients() {
        List<ClientDto> clients = clientService.getClients();
        return ResponseEntity.status(200).body(clients);
    }
}
