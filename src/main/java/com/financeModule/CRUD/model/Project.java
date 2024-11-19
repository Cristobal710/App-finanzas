package com.financeModule.CRUD.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Projects")
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

    private int HoursToComplete;
    private double projectValue;
    private String client;
    private Boolean projectFinished;
    private Boolean projectOfDeed;

    public Project(String clientName, int hoursToComplete, double projectValue){
        if (hoursToComplete <= 0){
            throw new IllegalArgumentException("hours should be bigger than cero");
        }
        if(clientName.isEmpty()){
            throw new IllegalArgumentException("name shouldnt be empty");
        }
        if(projectValue <= 0){
            throw new IllegalArgumentException("project value should be positive");
        }
        this.HoursToComplete = hoursToComplete;
        this.projectValue = projectValue;
        this.client = clientName;
        this.projectFinished = false;
        this.projectOfDeed = false;
    }
    public double calculateBillForHoursWorked(int hoursWorked){
        if (projectOfDeed) {
            return (projectValue/HoursToComplete) * hoursWorked;
        }
        throw new IllegalCallerException();
    }
}





