package com.example.lab.DTO;

import jakarta.persistence.Column;
import lombok.Data;


@Data
public class ProductoDto {

    private int id;


    private String nombre;


    private String estado;
}
