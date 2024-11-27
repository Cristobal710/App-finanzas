package com.financeModule.CRUD.Controller;


import com.financeModule.CRUD.Services.ClientService;
import com.financeModule.CRUD.Services.CostoMensualService;
import com.financeModule.CRUD.model.Client;
import com.financeModule.CRUD.model.CostoMensualDeActividad;
import com.financeModule.CRUD.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CostoMensualController {

    @Autowired
    private CostoMensualService costoMensualService;


    @PostMapping("/addCostoMensual")
    public ResponseEntity<CostoMensualDeActividad> addCostoMensual(@RequestBody CostoMensualDeActividad costo) {
        return costoMensualService.addCost(costo);
    }

    @GetMapping("/getAllCostos")
    public ResponseEntity<List<CostoMensualDeActividad>> getCostosMensuales() {
        return costoMensualService.getCostos();
    }
}
