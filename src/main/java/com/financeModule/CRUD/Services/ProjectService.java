package com.financeModule.CRUD.Services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.financeModule.CRUD.model.Project;
import com.financeModule.CRUD.repository.ProjectRepo;
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
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;


    public void getProjectsFromURL() {
        String url = "https://anypoint.mulesoft.com/mocking/api/v1/sources/exchange/assets/32c8fe38-22a6-4fbb-b461-170dfac937e4/proyectos-api/1.0.0/m/proyectos";

        try {
            HttpClient project = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = project.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();


                ObjectMapper objectMapper = new ObjectMapper();
                List<Project> projects = objectMapper.readValue(responseBody, objectMapper.getTypeFactory().constructCollectionType(List.class, Project.class));
                projectRepo.saveAll(projects);
            }

        } catch (IOException | InterruptedException ignored) {

        }
    }

    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectRepo.findAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    public ResponseEntity<Project> getProjectOfId(String id) {
        Optional<Project> ProjectData = projectRepo.findById(id);

        if (ProjectData.isPresent()){
            return new ResponseEntity<>(ProjectData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}



