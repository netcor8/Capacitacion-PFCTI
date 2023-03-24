package com.example.Labe.springData.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {

     private Integer estado;
     private int codigo;
     private String mensaje;

    public ErrorDto(Integer estado, String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }
}
