package com.example.lab.DTO;

import jakarta.persistence.Column;
import lombok.Data;


@Data
public class ProductoDto {

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
