package com.financeModule.CRUD.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CostoMensual")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CostoMensualDeActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String anio;

    private String mes;

    private String experienciaAsociada;

    private String actividadAsociada;

    private int costoDeLaActividad;

    public CostoMensualDeActividad(String anio, String mes, String experienciaAsociada, String actividadAsociada, int costoDeLaActividad) {
        if (anio == null || anio.isEmpty()) {
            throw new IllegalArgumentException("El año no puede estar vacío.");
        }
        if (mes == null || mes.isEmpty()) {
            throw new IllegalArgumentException("El mes no puede estar vacío.");
        }
        if (experienciaAsociada == null || experienciaAsociada.isEmpty()) {
            throw new IllegalArgumentException("La experiencia asociada no puede estar vacía.");
        }
        if (actividadAsociada == null || actividadAsociada.isEmpty()) {
            throw new IllegalArgumentException("La actividad asociada no puede estar vacía.");
        }
        if (costoDeLaActividad < 0) {
            throw new IllegalArgumentException("El costo de la actividad no puede ser negativo.");
        }
        this.anio = anio;
        this.mes = mes;
        this.experienciaAsociada = experienciaAsociada;
        this.actividadAsociada = actividadAsociada;
        this.costoDeLaActividad = costoDeLaActividad;
    }
}
