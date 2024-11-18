package com.financeModule.CRUD.repository;

import com.financeModule.CRUD.model.Resource;
import com.financeModule.CRUD.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, String> {
}
