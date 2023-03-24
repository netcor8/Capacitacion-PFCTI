package com.example.Labe.springbeans.business.Impl;

import com.example.Labe.springData.dto.ClienteDto;
import com.example.Labe.springData.model.Cliente;
import com.example.Labe.springData.repository.ClienteRepository;
import com.example.Labe.springbeans.business.BuscardoClientes;
import com.example.Labe.springbeans.dto.ClienteQueryDto;
import com.example.Labe.springbeans.dto.ClienteQueryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("baseDeDatos")
public class BuscadorClientesBd implements BuscardoClientes {
    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public List<ClienteDto> obtenerListaClientes(ClienteQueryDto clienteQueryDto) {
        List<Cliente> clientes = null;

        if(clienteQueryDto.getTipoBusqueda() == null){
          //  clienteQueryDto.setTipoBusqueda(defaultClienteQueryType);
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
