package com.financeModule.CRUD.model;


import jakarta.persistence.*;
import lombok.*;

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


}
