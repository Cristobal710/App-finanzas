package com.financeModule.CRUD.Services;


import com.financeModule.CRUD.model.Client;
import com.financeModule.CRUD.model.CostoMensualDeActividad;
import com.financeModule.CRUD.repository.CostoMensualRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CostoMensualService {
        @Autowired
        private CostoMensualRepo costoMensualRepo;


    public ResponseEntity<CostoMensualDeActividad> addCost(CostoMensualDeActividad costo) {
        CostoMensualDeActividad costoObj = costoMensualRepo.save(costo);
        return new ResponseEntity<>(costoObj , HttpStatus.CREATED);
    }
}
