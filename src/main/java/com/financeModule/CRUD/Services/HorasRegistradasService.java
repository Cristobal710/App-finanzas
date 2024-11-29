package com.financeModule.CRUD.Services;

import com.financeModule.CRUD.model.Role;
import org.springframework.stereotype.Service;

@Service
public class HorasRegistradasService {

    private int horasRegistradas;

    public void setHorasRegistradas(int horas){
        horasRegistradas = horas;
    }

    // Método para mockear valores en el feature
    public int obtenerHorasRegistradas(String anio, String mes, Role rol) {

        return horasRegistradas;
    }

    public int obtenerHorasRegistradas(String anio , String mes, String nombreProyecto){
        return horasRegistradas;
    }
}
