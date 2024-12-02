package com.financeModule.CRUD.Services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.financeModule.CRUD.model.CostoMensualDeActividad;
import com.financeModule.CRUD.model.Project;
import com.financeModule.CRUD.repository.CostoMensualRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProjectService {

    public String getMonthName(int monthNumber) {
        switch (monthNumber) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Septiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
            default:
                return "Invalid month";
        }
    }

    @Autowired
    private CostoMensualRepo costoMensualRepo;

    public ResponseEntity<List<Project>> getProjectsFromURL() {
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
                return new ResponseEntity<>(projects, HttpStatus.OK);
            }

        } catch (Exception ignored) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<List<Project>> getAllProjects() {
        ResponseEntity<List<Project>> projects = getProjectsFromURL();
        for (Project project : projects.getBody()) {
            ArrayList<Integer> costos = new ArrayList<>();

            for (int i = 1; i < 13; i++) {

                List<CostoMensualDeActividad> costosMes = costoMensualRepo.findByMes(getMonthName(i));

                int totalCostForMonth = 0;

                for (CostoMensualDeActividad costo : costosMes) {
                    double horasMes = requestWorkLogs(costo.getActividadAsociada(), costo.getExperienciaAsociada(), 2024, i);
                    totalCostForMonth += (int) (horasMes * costo.getCostoDeLaActividad());

                }
                costos.add(totalCostForMonth);
            }

            project.setCostosPorMes(costos);
        }
        return projects;
    }

    public ResponseEntity<Project> getProjectOfId(String id) {
        ResponseEntity<List<Project>> projects = getProjectsFromURL();

        Optional<Project> project = projects.getBody().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (project.isPresent()) {

            return new ResponseEntity<>(project.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Project>> getProjectsWithPeriod(int from, int to) {
        ResponseEntity<List<Project>> projects = getProjectsFromURL();

        for (Project project : projects.getBody()) {
            ArrayList<Integer> costos = new ArrayList<>();
            for (int i = from; from < to; i++) {

                //double horasMes = requestWorkLogs()
            }
        }
        return projects;
    }

    public double requestWorkLogs(String roleName, String roleExperience, int year, int month){

        try {
            // Define the base URL and parameters
            String baseUrl = "https://squad10-2024-2c.onrender.com/work_logs/roles";

            // Encode the parameters to ensure proper encoding for the URL
            String encodedRoleName = URLEncoder.encode(roleName, StandardCharsets.UTF_8);
            String encodedRoleExperience = URLEncoder.encode(roleExperience, StandardCharsets.UTF_8);
            String encodedYear = URLEncoder.encode(String.valueOf(year), StandardCharsets.UTF_8);
            String encodedMonth = URLEncoder.encode(String.valueOf(month), StandardCharsets.UTF_8);

            // Build the query string
            String queryString = String.format("role_name=%s&role_experience=%s&year=%s&month=%s",
                    encodedRoleName, encodedRoleExperience, encodedYear, encodedMonth);

            // Build the full URL with query parameters
            URI uri = URI.create(baseUrl + "?" + queryString);

            // Create HttpClient and HttpRequest objects
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            // Send the GET request and handle the response
            HttpResponse<String> response  = client.send(request, HttpResponse.BodyHandlers.ofString());
            return Double.parseDouble(response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }

}




