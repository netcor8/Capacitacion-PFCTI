package com.example.lab.Service;

import com.example.lab.Criterio.ClienteSpecification;
import com.example.lab.DTO.ClienteDto;
import com.example.lab.Model.Cliente;
import com.example.lab.repository.ClienteRepository;
import com.example.lab.repository.CuentaRepository;
import com.example.lab.repository.DireccionRepository;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.client.observation.ClientHttpObservationDocumentation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ClienteService {

   private  ClienteRepository clienteRepository;
   private DireccionRepository direccionRepository;
    private CuentaRepository cuentaRepository;

    private ClienteSpecification clienteSpecification;

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
        direccionRepository.deleteAllByCliente_id(idClienteDto);
        cuentaRepository.deleteAllByCliente_id(idClienteDto);
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


    public List<Cliente> buscarClientesPorApellido(String apellidos){
        return clienteRepository.buscarPorApellidos(apellidos);
    }

    public List<ClienteDto> buscarClientesPorApellidoNativo(String apellidos){
        List<ClienteDto> clienteDtos = new ArrayList<>();
        List<Tuple> tuples = clienteRepository.buscarPorApellidosNativo(apellidos);
        tuples.forEach(tuple -> {
            ClienteDto clienteDto = new ClienteDto();
            clienteDto.setApellido((String) tuple.get("apellidos"));
            clienteDto.setNombre((String) tuple.get("nombre"));
            clienteDto.setCedula((String) tuple.get("cedula"));
            clienteDtos.add(clienteDto);
            System.out.println(tuple.get("apellidos"));
        });
        return clienteDtos;
    }


    public List<ClienteDto> reportPorTipoClienteYCuenta(String tipoCliente){
        List<ClienteDto> result = new ArrayList<>();
        var clienteEntities = clienteRepository.reportPorTipoClienteYCuenta(tipoCliente);
        clienteEntities.forEach(tuple ->
                {
                    ClienteDto clienteDto = new ClienteDto();
                    /*-clienteDto.setNombre(tuple.get("nombre") getNombre());
                    clienteDto.setTelefono(entity.getTelefono());
                    clienteDto.setCedula(entity.getCedula());
                    clienteDto.setApellidos(entity.getApellidos());
                    clienteDto.setEstado(entity.isEstado());
                    clienteDto.setId(entity.getId());
                    clienteDto.setPaisNacimiento(entity.getPaisNacimiento());
                    result.add(clienteDto);*/
                }
        );
        return result;
    }
    public List<ClienteDto> buscarClientesDinamicamentePorCriterio(ClienteDto clienteDtoFilter){
        return clienteRepository.findAll(clienteSpecification.buildFilter(clienteDtoFilter))
                .stream().map(this::fromClienteToDto).collect(Collectors.toList());
    }
    private ClienteDto fromClienteToDto(Cliente cliente){
        ClienteDto clienteDto = new ClienteDto();
        BeanUtils.copyProperties(cliente, clienteDto);
        return clienteDto;
    }

    /*
    public List<ProductDto> obteneter(){
       cuentaRepository.find
               return numm
    }*/



}
