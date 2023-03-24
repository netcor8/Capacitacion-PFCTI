package com.example.Labe.springbeans;

import com.example.Labe.springData.dto.ClienteDto;
import com.example.Labe.springData.model.Cliente;
import com.example.Labe.springData.repository.ClienteRepository;
import com.example.Labe.springbeans.dto.ClienteQueryDto;
import com.example.Labe.springbeans.dto.ClienteQueryType;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdministradorClientes {

    public void setClienteRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    private  ClienteRepository clienteRepository;

      private ClienteQueryType defaultClienteQueryType;



    public AdministradorClientes(ClienteRepository clienteRepository , ClienteQueryType clienteQueryType) {
        System.out.println("Inicializando Constructor: " + this);
        this.clienteRepository = clienteRepository;
        this.defaultClienteQueryType = clienteQueryType;
    }




    public AdministradorClientes( ClienteQueryType clienteQueryType) {
       // this.clienteRepository = clienteRepository;
        this.defaultClienteQueryType = clienteQueryType;
    }



    public List<ClienteDto> obtenerListaClientesPorCriterio(ClienteQueryDto clienteQueryDto) {
        List<Cliente> clientes = null;

        if(clienteQueryDto.getTipoBusqueda() == null){
            clienteQueryDto.setTipoBusqueda(defaultClienteQueryType);
        }

        if (ClienteQueryType.CEDULA.equals(clienteQueryDto.getTipoBusqueda())) {
            clientes = this.clienteRepository.findByCedula(clienteQueryDto.getTextoBusqueda());
        } else if (ClienteQueryType.NOMBRES.equals(clienteQueryDto.getTipoBusqueda())) {
            clientes = this.clienteRepository.findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(clienteQueryDto.getTextoBusqueda(), clienteQueryDto.getTextoBusqueda());
        }
        return Optional.ofNullable(clientes).map(clientesAux-> clientesAux.stream().map(cliente -> {
            ClienteDto clienteDto = new ClienteDto();
            clienteDto.setNombre(cliente.getNombre());
            clienteDto.setApellido(cliente.getApellido());
            clienteDto.setCedula(cliente.getCedula());
            clienteDto.setTelefono(cliente.getTelefono());
            return clienteDto;
        }).collect(Collectors.toList())).orElse(new ArrayList<>());
    }
}
