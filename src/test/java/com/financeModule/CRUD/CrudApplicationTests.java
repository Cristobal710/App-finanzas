package com.financeModule.CRUD;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.financeModule.CRUD.model.Client;
import com.financeModule.CRUD.repository.ClientRepo;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CrudApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private ClientRepo clientRepo;

	private Client client1;
	private Client client2;

	@BeforeEach
	void setUp() {
		if (clientRepo.count() != 0){
			clientRepo.deleteAll();
		}
		// Create two new clients for the test
		client1 = new Client(null, "Pepe");
		client2 = new Client(null, "Juan");

		// Save clients to the database
		clientRepo.save(client1);
		clientRepo.save(client2);
	}

	@Test
	void testAddClient() {
		// Send POST request to create the client1
		ResponseEntity<Client> response = restTemplate.postForEntity("/addClient", client1, Client.class);

		// Assert that the response status is CREATED (201 Created)
		Assert.isTrue(response.getStatusCode() == HttpStatus.CREATED, "Client creation should return 201 CREATED");

		// Assert that the client1 returned in the response is not null
		Client createdClient = response.getBody();
		Assert.notNull(createdClient, "Created client1 should not be null");

		// Verify that the client1 name is correct
		Assert.isTrue(createdClient.getNombreCliente().equals("Pepe"), "Client name should be 'Pepe'");

	}
	@Test
	void testAddClientOnDataBaseAndGetItWithID() {

		ResponseEntity<Client> response = restTemplate.postForEntity("/addClient", client1, Client.class);
		Assert.isTrue(response.getStatusCode() == HttpStatus.CREATED, "Client creation should return 200 OK");

		Client createdClient = response.getBody();
		// Verify that the client1 ID is correct
		Assert.isTrue(createdClient.getID() == 1, "Client 'Pepe' should have ID 1");

		// Verify that the client1 was saved in the database
		Client foundClient = clientRepo.findById(createdClient.getID()).orElse(null);
		Assert.notNull(foundClient, "Client should be saved in the database");

		// Optionally: Verify that the saved client1's name matches
		Assert.isTrue(foundClient.getNombreCliente().equals("Pepe"), "Saved client1 name should be 'Pepe'");
	}

	@Test
	void testGetAllClients() {
		// Send GET request to fetch all clients
		ResponseEntity<List> response = restTemplate.getForEntity("/getAllClients", List.class);

		// Assert that the response status is OK (200)
		Assert.isTrue(response.getStatusCode() == HttpStatus.OK, "Response should be OK (200)");

		// Assert that the response body contains a list of clients
		List<Client> clients = response.getBody();
		Assert.notNull(clients, "Client list should not be null");

		// Assert that the list contains 2 clients
		Assert.isTrue(clients.size() == 2, "There should be 2 clients in the list");

	}

}
