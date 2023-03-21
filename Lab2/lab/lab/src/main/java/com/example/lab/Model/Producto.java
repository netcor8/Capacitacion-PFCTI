package com.example.lab.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="producto")
@Setter
@Getter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre"
            , length = 50
            , columnDefinition = "varchar(50)")
    private String nombre;

    @Column(name = "estado"
            , length = 50
            , columnDefinition = "varchar(50)")
    private String estado;



}
