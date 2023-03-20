package com.example.lab.Service;

import com.example.lab.DTO.ClienteDto;
import com.example.lab.Model.Cliente;
import com.example.lab.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

   private  ClienteRepository clienteRepository;

   public void insertarCliente(ClienteDto clienteDto){
       Cliente cliente = new Cliente();
       cliente.setApellidos(clienteDto.getApellido());
       cliente.setNombre(clienteDto.getNombre());
       cliente.setCedula(clienteDto.getCedula());
       cliente.setTelefono(clienteDto.getTelefono());
       clienteRepository.save(cliente);
   }

   public ClienteDto obtenerCliente(int idCliente){
      Cliente cliente = clienteRepository.findById(idCliente).
              orElseThrow(
                    ()->{throw new RuntimeException("Cliente no Existe");
                    });
       ClienteDto clienteDto = new ClienteDto();
       clienteDto.setId(cliente.getId());
       clienteDto.setApellido(cliente.getApellidos());
       clienteDto.setNombre(cliente.getNombre());
       clienteDto.setCedula(cliente.getCedula());
       return clienteDto;
   }

    public void actualizarCliente(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setId(clienteDto.getId());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellidos(clienteDto.getApellido());
        cliente.setCedula(clienteDto.getCedula());
        cliente.setTelefono(clienteDto.getTelefono());
        clienteRepository.save(cliente);
    }

   public void eliminarCliente(Integer idClienteDto) {
       clienteRepository.deleteById(idClienteDto);
   }


    public List<ClienteDto> obtenerClientesPorCodigoISOPaisYCuentasActivas(String codigoISOPais){
        List<ClienteDto> resultadoClientesDto = new ArrayList<>();
        List<Cliente> clientes = clienteRepository.findClientesByPaisNacimientoAndCuentas_EstadoIsTrue(codigoISOPais);
        clientes.forEach(cliente -> {
            ClienteDto clienteDto = new ClienteDto();
            clienteDto.setId(cliente.getId());
            clienteDto.setApellido(cliente.getApellidos());
            clienteDto.setNombre(cliente.getNombre());
            clienteDto.setCedula(cliente.getCedula());
            clienteDto.setPais(cliente.getPais());
            resultadoClientesDto.add(clienteDto);
            System.out.println(clienteDto);
        });
        return resultadoClientesDto;
    }



}
