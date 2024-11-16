package com.financeModule.CRUD.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Projects")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String nombreProyecto;
    private int totalHorasConsumidas;
    private int costoTotalDeProyecto;
    private int ROI;
    private int ganancias;

    @ManyToOne
    @JoinColumn(name = "clienteID", referencedColumnName = "ID", nullable = false)
    private Client client;
}





