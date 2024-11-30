package com.financeModule.CRUD.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.financeModule.CRUD.model.Resource;
import com.financeModule.CRUD.model.Role;
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

@Service
public class ResourceService {

    @Autowired
    private RoleService roleService;

    public ResponseEntity<List<Resource>> getResourcesFromURL() {
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
                return new ResponseEntity<>(resources, HttpStatus.OK);
            }

        } catch (IOException | InterruptedException ignored) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<List<Resource>> getAllResources() {
        ResponseEntity<List<Resource>> resources = getResourcesFromURL();
        return resources;
    }
}
