package com.example.Labe.springbeans.business;

import com.example.Labe.springData.dto.ClienteDto;
import com.example.Labe.springData.repository.ClienteRepository;
import com.example.Labe.springbeans.AdministradorClientes;
import com.example.Labe.springbeans.business.Impl.BuscarClientesSysExt;
import com.example.Labe.springbeans.dto.ClienteQueryDto;
import com.example.Labe.springbeans.dto.ClienteQueryType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuscardoClientesTest {

    @Autowired
    private BuscardoClientes baseDeDatos;

    @Autowired
    @Qualifier("sistemaExterno")
    private BuscardoClientes sistemaExterno;


    @Test
    void obtenerListaClientesBaseDeDatos() {
       ClienteQueryDto clienteQueryDto = new ClienteQueryDto();
       clienteQueryDto.setTextoBusqueda("1111");
       clienteQueryDto.setTipoBusqueda(ClienteQueryType.CEDULA);
       List<ClienteDto> resultadoCLienteDto = baseDeDatos.obtenerListaClientes(clienteQueryDto);
       System.out.println("Resultado de la busqueda: " + resultadoCLienteDto.size());
        Assertions.assertEquals(2,resultadoCLienteDto.size());
    }




    @Test
    void obtenerListaClientesDeSistemaExterno(){
        ClienteQueryDto clienteQueryDto = new ClienteQueryDto();
        clienteQueryDto.setTextoBusqueda("1890000000");
        clienteQueryDto.setTipoBusqueda(ClienteQueryType.CEDULA);
        List<ClienteDto> resultadoClienteDtos = sistemaExterno.obtenerListaClientes(clienteQueryDto);
        resultadoClienteDtos.forEach(clienteDto ->
                {
                    System.out.println("Resultado de la busqueda" + clienteDto.getNombre() + clienteDto.getApellido());
                }
        );
        Assertions.assertEquals(1, resultadoClienteDtos.size());
    }
}