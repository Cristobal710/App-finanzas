package com.financeModule.CRUD.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Resources")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Resource {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "dni")
    private int dni;


    @Column(name = "IdRol")
    @JsonProperty("rolId")
    private String IdRol;  // This is the foreign key to Role




    public Resource(String name, String role, String activity, int dni){
        if (dni <= 0){
            throw new IllegalArgumentException("DNI is not valid");
        }
        if(name.isEmpty()){
            throw new IllegalArgumentException("name shouldnt be empty");
        }
        if(role.isEmpty()){
            throw new IllegalArgumentException("role shouldnt be empty");
        }
        if(activity.isEmpty()){
            throw new IllegalArgumentException("activity shouldnt be empty");
        }
        this.nombre = name;
        //this.role = new Role(activity, role);
        this.dni = dni;
    }


}
