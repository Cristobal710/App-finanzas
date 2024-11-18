package com.financeModule.CRUD.Controller;


import com.financeModule.CRUD.Services.ProjectService;
import com.financeModule.CRUD.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/getAllProjects")
    public ResponseEntity<List<Project>> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/getProjectOfId/{id}")
    public ResponseEntity<Project> getTasksOfProject(@PathVariable String id) {
        return projectService.getProjectOfId(id);
    }
}
