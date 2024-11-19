package com.financeModule.CRUD.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Entity
@Table(name="clientes")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String nombreCliente;

    private int projects;
    private int projectsDelayed;

    public Client(String name, int amountOfProjects){
        if(name.isEmpty()){
            throw new IllegalArgumentException();
        }
        if (amountOfProjects < 0){
            throw new IllegalArgumentException();
        }
        this.nombreCliente = name;
        this.projects = amountOfProjects;
        this.projectsDelayed = 0;
    }
}
