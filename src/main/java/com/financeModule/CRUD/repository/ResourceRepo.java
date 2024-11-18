package com.financeModule.CRUD.repository;

import com.financeModule.CRUD.model.Project;
import com.financeModule.CRUD.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepo extends JpaRepository<Resource, String> {
}
