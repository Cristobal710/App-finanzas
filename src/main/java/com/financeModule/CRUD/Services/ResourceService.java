package com.financeModule.CRUD.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.financeModule.CRUD.model.Resource;
import com.financeModule.CRUD.model.Role;
import com.financeModule.CRUD.repository.ResourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    @Autowired
    private ResourceRepo resourceRepo;

    @Autowired
    private RoleService roleService;

    public void getResourcesFromURL() {
        String url = "https://anypoint.mulesoft.com/mocking/api/v1/sources/exchange/assets/32c8fe38-22a6-4fbb-b461-170dfac937e4/recursos-api/1.0.1/m/recursos";

        try {
            HttpClient resource = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = resource.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();


                ObjectMapper objectMapper = new ObjectMapper();
                List<Resource> resources = objectMapper.readValue(responseBody, objectMapper.getTypeFactory().constructCollectionType(List.class, Resource.class));
                    resourceRepo.saveAll(resources);
                }

        } catch (IOException | InterruptedException ignored) {

        }
    }

    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceRepo.findAll();
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }
}
