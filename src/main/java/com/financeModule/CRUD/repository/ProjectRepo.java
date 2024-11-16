package com.financeModule.CRUD.repository;

import com.financeModule.CRUD.model.Client;
import com.financeModule.CRUD.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {

    boolean existsByClient(Client client);
}