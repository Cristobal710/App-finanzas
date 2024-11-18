package com.financeModule.CRUD.Controller;

import com.financeModule.CRUD.Services.ResourceService;
import com.financeModule.CRUD.Services.RoleService;
import com.financeModule.CRUD.model.Resource;
import com.financeModule.CRUD.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/getAllRoles")
    public ResponseEntity<List<Role>> getAllRoles() {
        return roleService.getAllRoles();
    }
}
