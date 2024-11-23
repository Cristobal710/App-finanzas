package com.financeModule.CRUD.model;

import com.financeModule.CRUD.Services.ResourceService;
import com.financeModule.CRUD.Services.RoleService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    private final ResourceService resourceService;

    private final RoleService roleService;

    public DatabaseInitializer(ResourceService resourceService, RoleService roleService) {
        this.resourceService = resourceService;
        this.roleService = roleService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        roleService.getRolesFromURL();

        resourceService.getResourcesFromURL();
    }
}

