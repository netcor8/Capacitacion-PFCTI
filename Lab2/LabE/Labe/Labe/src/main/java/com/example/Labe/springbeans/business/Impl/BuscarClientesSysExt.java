package com.example.Labe.springbeans.business.Impl;

import com.example.Labe.springData.dto.ClienteDto;
import com.example.Labe.springbeans.business.BuscardoClientes;
import com.example.Labe.springbeans.dto.ClienteQueryDto;
import com.example.Labe.springbeans.dto.ClienteQueryType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("sistemaExterno")
public class BuscarClientesSysExt implements BuscardoClientes {
    @Override
    public List<ClienteDto> obtenerListaClientes(ClienteQueryDto clienteQueryDto) {
        List<ClienteDto> resultadoClientes = List.of(
                new ClienteDto(1, "Alberto", "Salazar", "1890000000", "0999714563", true, "CR"),
                new ClienteDto(2, "Rosa", "Salazar", "1890000001", "0983475616", true, "CR"),
                new ClienteDto(3, "Alexis", "Vivanco", "1890000002", "0983475616", true, "CR"),
                new ClienteDto(4, "Natalie", "Vivanco", "1890000003", "0983665616", true, "CR"),
                new ClienteDto(5, "Ximena", "Silva", "1890000004", "0983475616", true, "CR"),
                new ClienteDto(6, "Thalia", "Rodriguez", "1890000005", "0983475616", true, "CR"),
                new ClienteDto(7, "Jonh", "Rodriguez", "1890000006", "0983475616", true, "CR"),
                new ClienteDto(8, "Eduardo", "Guerra", "1890000007", "0983475616", true, "CR"),
                new ClienteDto(9, "Juan", "Vaca", "1890000008", "0983475616", true, "CR"),
                new ClienteDto(10, "Cristina", "Ortiz", "1890000009", "0983475616", true, "CR"));
       // return resultadoClientes;
        return resultadoClientes.stream().filter(filter ->
                        clienteQueryDto.getTipoBusqueda() == ClienteQueryType.NOMBRES ?
                                filter.getNombre().equals(clienteQueryDto.getTextoBusqueda())
                                : filter.getCedula().equals(clienteQueryDto.getTextoBusqueda()))
                .toList();

    }

}
