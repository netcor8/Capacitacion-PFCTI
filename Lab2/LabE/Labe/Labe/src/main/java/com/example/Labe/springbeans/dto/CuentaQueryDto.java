package com.example.Labe.springbeans.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CuentaQueryDto {

    private String textoBusqueda;
    private CuentaQueryType tipoBusqueda;

    private int clienteId;
}
