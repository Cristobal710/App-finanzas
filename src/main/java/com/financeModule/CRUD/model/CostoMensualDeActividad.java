package com.financeModule.CRUD.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="CostoMensual")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CostoMensualDeActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int mes;

    private String experienciaAsociada;

    private String actividadAsociada;

    private int costoDeLaActividad;
}
