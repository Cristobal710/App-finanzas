package com.financeModule.CRUD.model;

import com.financeModule.CRUD.Services.ProjectService;
import com.financeModule.CRUD.Services.ResourceService;
import com.financeModule.CRUD.Services.RoleService;
import com.financeModule.CRUD.model.Project;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    private final ProjectService projectService;

    private final ResourceService resourceService;

    private final RoleService roleService;

    public DatabaseInitializer(ProjectService projectService, ResourceService resourceService, RoleService roleService) {
        this.projectService = projectService;
        this.resourceService = resourceService;
        this.roleService = roleService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        projectService.getProjectsFromURL();

        roleService.getRolesFromURL();

        resourceService.getResourcesFromURL();
    }
}

