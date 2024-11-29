package com.financeModule.CRUD.repository;


import com.financeModule.CRUD.model.CostoMensualDeActividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostoMensualRepo extends JpaRepository<CostoMensualDeActividad, Long> {
    List<CostoMensualDeActividad> findByMes(int mes);
}
