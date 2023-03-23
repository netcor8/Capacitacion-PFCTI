package com.example.Labe.springbeans.business;

import com.example.Labe.springData.dto.ClienteDto;
import com.example.Labe.springData.dto.CuentaDto;
import com.example.Labe.springbeans.dto.ClienteQueryDto;
import com.example.Labe.springbeans.dto.CuentaQueryDto;

import java.util.List;

public interface BuscardorCuentas {

    List<CuentaDto> obtenerListaCuentas(CuentaQueryDto clienteQueryDto);
}
