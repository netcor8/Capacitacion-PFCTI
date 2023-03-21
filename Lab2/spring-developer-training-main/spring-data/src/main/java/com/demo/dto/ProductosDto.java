package com.demo.dto;

import com.demo.model.Cliente;
import lombok.Data;

import java.util.List;

@Data
public class ProductosDto {
    private List<CuentaDto> cuentaDtos;
    private List<TarjetaDto> tarjetaDtos;
    private List<InversionDto> inversionDtos;
}
