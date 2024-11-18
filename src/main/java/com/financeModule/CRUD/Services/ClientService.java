package com.financeModule.CRUD.Services;

import com.financeModule.CRUD.Exceptions.ClientHasProjectsException;
import com.financeModule.CRUD.model.Client;
import com.financeModule.CRUD.repository.ClientRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;


    public ResponseEntity<String> deleteClient(Long clientId) {

        Optional<Client> clientOptional = clientRepo.findById(clientId);
        if (!clientOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Client client = clientOptional.get();

        clientRepo.delete(client);

        return new ResponseEntity<>(HttpStatus.OK);

    }

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


    public ResponseEntity<Client> getClientWithId(Long id){
        Optional<Client> clientData = clientRepo.findById(id);

        if (clientData.isPresent()){
            return new ResponseEntity<>(clientData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Client> addClient(Client client){
        Client clientObj = clientRepo.save(client);
        return new ResponseEntity<>(clientObj , HttpStatus.CREATED);
    }

    public ResponseEntity<Client> updateClientWithID(Long id, Client newClientData) {
        Optional<Client> oldClientData = clientRepo.findById(id);

        if (oldClientData.isPresent()){
            Client client = oldClientData.get();
            client.setNombreCliente(newClientData.getNombreCliente());

            Client clientObj = clientRepo.save(client);
            return new ResponseEntity<>(clientObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
