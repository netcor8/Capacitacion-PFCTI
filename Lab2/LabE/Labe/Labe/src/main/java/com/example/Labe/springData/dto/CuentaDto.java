package com.example.Labe.springData.dto;

import lombok.Data;

@Data
public class CuentaDto {
    private int id;
    private String numero;
    private String tipo;
    private Boolean estado; // activo/desactivo
}
