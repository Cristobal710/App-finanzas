package com.financeModule.CRUD.repository;


import com.financeModule.CRUD.model.CostoMensualDeActividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostoMensualRepo extends JpaRepository<CostoMensualDeActividad, Long> {
}
