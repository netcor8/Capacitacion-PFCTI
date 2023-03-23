package com.example.Labe.springbeans.business.Impl;

import com.example.Labe.springData.dto.ClienteDto;
import com.example.Labe.springData.dto.CuentaDto;
import com.example.Labe.springData.model.Cliente;
import com.example.Labe.springData.repository.ClienteRepository;
import com.example.Labe.springbeans.business.BuscardoClientes;
import com.example.Labe.springbeans.business.BuscardorCuentas;
import com.example.Labe.springbeans.dto.ClienteQueryDto;
import com.example.Labe.springbeans.dto.ClienteQueryType;
import com.example.Labe.springbeans.dto.CuentaQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("baseDeDatoscuentas")
public class BuscadorCuentasBd implements BuscardorCuentas {
    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public List<CuentaDto>  obtenerListaCuentas(CuentaQueryDto clienteQueryDto) {
        return null;
    }

}
