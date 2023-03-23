package com.example.Labe.springbeans.business.Impl;

import com.example.Labe.springData.dto.ClienteDto;
import com.example.Labe.springData.dto.CuentaDto;
import com.example.Labe.springbeans.business.BuscardoClientes;
import com.example.Labe.springbeans.business.BuscardorCuentas;
import com.example.Labe.springbeans.dto.ClienteQueryDto;
import com.example.Labe.springbeans.dto.ClienteQueryType;
import com.example.Labe.springbeans.dto.CuentaQueryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sistemaExternocuentas")
public class BuscarCuentasSysExt implements BuscardorCuentas {


    @Override
    public List<CuentaDto>  obtenerListaCuentas(CuentaQueryDto clienteQueryDto) {
        var cuentas = List.of(
                new CuentaDto(1, "12345", "EFEC", true, 1),
                new CuentaDto(2, "123456", "EFEC", true, 1),
                new CuentaDto(3, "123457", "EFEC", true, 1),
                new CuentaDto(4, "12345678", "EFEC", true, 2),
                new CuentaDto(5, "12345679", "EFEC", true, 3),
                new CuentaDto(6, "12345670", "EFEC", true, 4)
        );
        return cuentas.stream().filter(filter ->
                        filter.getClienteId() == clienteQueryDto.getClienteId())
                .toList();
    }
}
