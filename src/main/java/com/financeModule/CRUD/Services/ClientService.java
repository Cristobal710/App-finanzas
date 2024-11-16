package com.financeModule.CRUD.Services;

import com.financeModule.CRUD.Exceptions.ClientHasProjectsException;
import com.financeModule.CRUD.model.Client;
import com.financeModule.CRUD.repository.ClientRepo;
import com.financeModule.CRUD.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private ProjectRepo projectRepo;

    /**
     * Method to delete a client if no associated projects exist.
     *
     * @param clientId The ID of the client to be deleted.
     * @throws ClientHasProjectsException If the client has associated projects.
     * @throws RuntimeException If the client is not found.
     */
    public void deleteClient(Long clientId) {

        // Check if client exists

        Optional<Client> clientOptional = clientRepo.findById(clientId);
        if (!clientOptional.isPresent()) {
            throw new RuntimeException("Client not found with ID: " + clientId);
        }

        Client client = clientOptional.get();

        // Check if the client has associated projects
        boolean hasProjects = projectRepo.existsByClient(client);
        if (hasProjects) {
            // Throw exception if client has projects
            throw new ClientHasProjectsException("Cannot delete client. The client has associated projects.");
        }

        // Proceed with deletion if no associated projects
        clientRepo.delete(client);
    }
}
