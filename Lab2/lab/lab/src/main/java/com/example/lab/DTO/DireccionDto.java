package com.example.lab.DTO;

import com.example.lab.Model.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class DireccionDto {

    private int id;
    private String direccion;
    private String nomenclatura;
    //private Cliente cliente;
}
