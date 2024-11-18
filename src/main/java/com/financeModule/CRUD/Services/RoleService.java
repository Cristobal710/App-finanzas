package com.financeModule.CRUD.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.financeModule.CRUD.model.Role;
import com.financeModule.CRUD.repository.RoleRepo;
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
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public void getRolesFromURL() {
        String url = "https://anypoint.mulesoft.com/mocking/api/v1/sources/exchange/assets/32c8fe38-22a6-4fbb-b461-170dfac937e4/roles-api/1.0.0/m/roles";

        try {
            HttpClient role = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = role.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();


                ObjectMapper objectMapper = new ObjectMapper();
                List<Role> roles = objectMapper.readValue(responseBody, objectMapper.getTypeFactory().constructCollectionType(List.class, Role.class));
                roleRepo.saveAll(roles);
            }

        } catch (IOException | InterruptedException ignored) {

        }
    }
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleRepo.findAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
