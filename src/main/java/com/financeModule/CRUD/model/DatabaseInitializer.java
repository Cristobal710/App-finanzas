package com.financeModule.CRUD.model;

import com.financeModule.CRUD.Services.ResourceService;
import com.financeModule.CRUD.Services.RoleService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    private final ResourceService resourceService;

    public DatabaseInitializer(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        resourceService.getResourcesFromURL();
    }
}

