package com.financeModule.CRUD.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Role {

    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private String id;

    @Column(name = "nombre")
    @JsonProperty("nombre")
    private String nombre;

    @Column(name = "experiencia")
    @JsonProperty("experiencia")
    private String experiencia;

    private double wage;

    public static final double SENIOR_WAGE_DEVELOPER = 1000.0;
    public static final double SEMI_SENIOR_WAGE_DEVELOPER = 750.0;
    public static final double JUNIOR_WAGE_DEVELOPER = 500.0;

    public static final double SENIOR_WAGE_ANALIST = 1500.0;
    public static final double SEMI_SENIOR_WAGE_ANALIST = 1200.0;
    public static final double JUNIOR_WAGE_ANALIST = 1000.0;

    public static final String SENIOR = "Senior";
    public static final String SEMI_SENIOR = "Semi-Senior";
    public static final String JUNIOR = "Junior";
    public static final String DESARROLLADOR = "Desarrollador";
    public static final String ANALISTA = "Analista";

    Role(String nombre, String tipoRol){

        this.nombre = nombre;
        this.experiencia = tipoRol;
        if (nombre.equals(DESARROLLADOR)){
            if (tipoRol.equals(SENIOR)){
                this.wage = SENIOR_WAGE_DEVELOPER;
            } else if (tipoRol.equals(JUNIOR)){
                this.wage = JUNIOR_WAGE_DEVELOPER;
            } else if (tipoRol.equals(SEMI_SENIOR)) {
                this.wage = SEMI_SENIOR_WAGE_DEVELOPER;
            }
        }
        if (nombre.equals(ANALISTA)){
            if (tipoRol.equals(SENIOR)){
                this.wage = SENIOR_WAGE_ANALIST;
            } else if (tipoRol.equals(JUNIOR)){
                this.wage = JUNIOR_WAGE_ANALIST;
            } else if (tipoRol.equals(SEMI_SENIOR)) {
                this.wage = SEMI_SENIOR_WAGE_ANALIST;
            }
        }
    }
}