package com.demo.services;

import com.demo.criteria.ClienteSpecification;
import com.demo.dto.*;
import com.demo.model.Cliente;
import com.demo.model.Cuenta;
import com.demo.model.Inversion;
import com.demo.model.Tarjeta;
import com.demo.repository.ClienteRepository;
import com.demo.repository.CuentaRepository;
import com.demo.repository.DireccionRepository;
import com.demo.repository.TarjetaRepository;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class ClienteService {
    private ClienteRepository clienteRepository;
    private DireccionRepository direccionRepository;
    private CuentaRepository cuentaRepository;
    private TarjetaRepository tarjetaRepository;
    private ClienteSpecification clienteSpecification;

    public void insertarCliente (ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setApellidos(clienteDto.getApellido());
        cliente.setNombre(cliente.getNombre());
        cliente.setCedula(cliente.getCedula());
        cliente.setTelefono(cliente.getTelefono());
        clienteRepository.save(cliente);
    }

    public ClienteDto obtenerCliente (int idCliente){
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> {throw new RuntimeException("Clinete no Existe");});
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(cliente.getId());
        clienteDto.setApellido(cliente.getApellidos());
        clienteDto.setNombre(cliente.getNombre());
        clienteDto.setCedula(cliente.getCedula());
        return clienteDto;
    }

    public ClienteDto actualizarCliente(ClienteDto clienteDto) {
        Cliente cliente = clienteRepository.findById(clienteDto.getId())
                .orElseThrow(() -> {throw new RuntimeException("Clinete no Existe");});
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellidos(clienteDto.getApellido());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setCedula(clienteDto.getCedula());
        clienteRepository.save(cliente);
        return null;
    }

    public void actualizarCliente2(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setId(clienteDto.getId());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellidos(clienteDto.getApellido());
        cliente.setCedula(clienteDto.getCedula());
        cliente.setTelefono(clienteDto.getTelefono());
        clienteRepository.save(cliente);
    }

    public void eliminarCliente(Integer clienteId){
        direccionRepository.deleteAllByCliente_Id(clienteId);
        cuentaRepository.deleteAllByCliente_Id(clienteId);
        clienteRepository.deleteById(clienteId);
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
            clienteDto.setPaisNacimiento(cliente.getPaisNacimiento());
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

    public List<ClienteDto> buscarClienteExtranjerosPorTarjeta_Inactiva(){
        List<ClienteDto> clienteDtos = new ArrayList<>();
        List<Tuple> tuples = clienteRepository.buscarClienteExtranjerosPorTarjeta_Inactiva();
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

    private ClienteDto fromClienteToDto(Cliente cliente){
        ClienteDto clienteDto = new ClienteDto();
        BeanUtils.copyProperties(cliente, clienteDto);
        return clienteDto;
    }

    public List<ClienteDto> buscarClientesDinamicamentePorCriterio(ClienteDto clienteDtoFilter){
        return clienteRepository.findAll(clienteSpecification.buildFilter(clienteDtoFilter))
                .stream().map(this::fromClienteToDto).collect(Collectors.toList());

    }

    /*public ProductosDto obtenerTodosLosProductosDeUnCliente(){
        //cuentaRepository.findAllById();
        //tarjetaRepository
        return null;
    }*/

    private CuentaDto fromCuentaToDto(Cuenta cuenta){
        CuentaDto cuentaDto = new CuentaDto();
        BeanUtils.copyProperties(cuenta, cuentaDto);
        return cuentaDto;
    }
    private TarjetaDto fromTarjetaToDto(Tarjeta tarjeta) {
        TarjetaDto tarjetaDto = new TarjetaDto();
        BeanUtils.copyProperties(tarjeta, tarjetaDto);
        return tarjetaDto;
    }

    private InversionDto fromInversionToDto(Inversion inversion) {
        InversionDto inversionDto = new InversionDto();
        BeanUtils.copyProperties(inversion, inversionDto);
        return inversionDto;
    }
    public ProductosDto obtenerTodosLosProductosDeUnClientePorId(int id){
        ProductosDto productosDto = new ProductosDto();
        List<CuentaDto> cuentaDtos = new ArrayList<>();
        cuentaRepository.findByCliente_Id(id).forEach(
                cuenta -> {
                    CuentaDto cuentaDto;
                    cuentaDto = fromCuentaToDto(cuenta);
                    cuentaDtos.add(cuentaDto);
                });
        productosDto.setCuentaDtos(cuentaDtos);

        List<TarjetaDto> tarjetaDtos = new ArrayList<>();
        tarjetaRepository.findByCliente_Id(id).forEach(
                tarjeta -> {
                    TarjetaDto tarjetaDto;
                    tarjetaDto = fromTarjetaToDto(tarjeta);
                    tarjetaDtos.add(tarjetaDto);
                });
        productosDto.setCuentaDtos(cuentaDtos);


        return productosDto;
    }
}
