package com.financeModule.CRUD.Controller;


import com.financeModule.CRUD.Exceptions.ClientHasProjectsException;
import com.financeModule.CRUD.Services.ClientService;
import com.financeModule.CRUD.model.Client;
import com.financeModule.CRUD.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

public class ClientControler {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepo clientRepo;


    @GetMapping("/getAllClients")
    public ResponseEntity<List<Client>> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/getClientWithID/{id}")
    public ResponseEntity<Client> getClientWithID(@PathVariable Long id) {
        return clientService.getClientWithId(id);
    }

    @PostMapping("/addClient")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PostMapping("/updateClientWithID/{id}")
    public ResponseEntity<Client> updateClientWithID(@PathVariable Long id, @RequestBody Client newClientData) {
        return clientService.updateClientWithID(id, newClientData);
    }


    @DeleteMapping("/deleteClientWithID/{id}")
    public ResponseEntity<String> deleteClientWithID(@PathVariable Long id) {
        return clientService.deleteClient(id);
    }
}
