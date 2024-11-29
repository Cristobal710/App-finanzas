package com.financeModule.CRUD.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Project {

    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private String id;

    @Column(name = "nombre")
    @JsonProperty("nombre")
    private String nombre;

    @Column(name = "descripcion", length = 1000)
    @JsonProperty("descripcion")
    private String descripcion;

    @Setter
    private List<Integer> costosPorMes;

}





