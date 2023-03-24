package com.example.Labe.springData.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {


    private int id;
    private String nombre;
    private String apellido;
    private String cedula;

    private String telefono;

    private boolean estado;
    private String paisNacimiento;

    //private List<DireccionDto> direccionsDto;

    //private List<CuentaDto> cuentas;
}