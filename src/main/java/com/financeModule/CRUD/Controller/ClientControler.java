package com.financeModule.CRUD.Controller;


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
    private ClientRepo clientRepo;


    @GetMapping("/getAllClients")
    public ResponseEntity<List<Client>> getAllClients(){
        try {
            List<Client> ClientsList = new ArrayList<>();
            clientRepo.findAll().forEach(ClientsList::add);

            if (ClientsList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(ClientsList , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getClientWithID/{id}")
    public ResponseEntity<Client> getClientWithID(@PathVariable Long id) {
        Optional<Client> clientData = clientRepo.findById(id);

        if (clientData.isPresent()){
            return new ResponseEntity<>(clientData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addClient")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client clientObj = clientRepo.save(client);

        return new ResponseEntity<>(clientObj , HttpStatus.CREATED);
    }

    @PostMapping("/updateClientWithID/{id}")
    public ResponseEntity<Client> updateClientWithID(@PathVariable Long id, @RequestBody Client newClientData) {
        Optional<Client> oldClientData = clientRepo.findById(id);

        if (oldClientData.isPresent()){
            Client client = oldClientData.get();
            client.setNombreCliente(newClientData.getNombreCliente());

            Client clientObj = clientRepo.save(client);
            return new ResponseEntity<>(clientObj, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteClientWithID/{id}")
    public ResponseEntity<HttpStatus> deleteClientWithID(@PathVariable Long id) {
            clientRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
