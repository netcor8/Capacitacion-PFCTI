package com.example.Labe.springbeans.business;

import com.example.Labe.springData.dto.ClienteDto;
import com.example.Labe.springbeans.dto.ClienteQueryDto;

import java.util.List;

public interface BuscardoClientes {

    List<ClienteDto> obtenerListaClientes(ClienteQueryDto clienteQueryDto);



}
