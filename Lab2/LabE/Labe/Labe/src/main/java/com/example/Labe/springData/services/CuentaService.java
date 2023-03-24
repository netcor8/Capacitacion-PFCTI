package com.example.Labe.springData.services;

import com.example.Labe.springData.criteria.CuentaSpecification;
import com.example.Labe.springData.dto.ClienteDto;
import  com.example.Labe.springData.dto.CuentaDto;
import com.example.Labe.springData.model.Cliente;
import  com.example.Labe.springData.model.Cuenta;
import com.example.Labe.springData.repository.CuentaRepository;
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
public class CuentaService {
    private CuentaRepository cuentaRepository;
    private CuentaSpecification cuentaSpecification;

    private CuentaDto fromCuentaToDto(Cuenta cuenta){
        CuentaDto cuentaDto = new CuentaDto();
        BeanUtils.copyProperties(cuenta, cuentaDto);
        return cuentaDto;
    }

    public List<CuentaDto> buscarCuentasDinamicamentePorCriterio(CuentaDto cuentaDtoFilter){
        return cuentaRepository.findAll(cuentaSpecification.buildFilter(cuentaDtoFilter))
                .stream().map(this::fromCuentaToDto).collect(Collectors.toList());
    }

    public List<CuentaDto> buscarCuentasPorCliente(int idCliente) {
        List<CuentaDto> cuentasPorCliente = new ArrayList<>();
        cuentaRepository.findCuentasByCliente_IdAndEstadoIsTrue(idCliente)
                .stream()
                .map(cuenta -> {
                    cuentasPorCliente.add(fromCuentaToDto(cuenta));
                    //  log.info("Cuenta de Cliente :{}", cuenta);
                    return cuenta;}
                ).collect(Collectors.toList());
        return cuentasPorCliente;
    }

    public void insertarCuenta (CuentaDto cuentaDto,ClienteDto clienteDto){
        Cuenta cuenta = new Cuenta();

        cuenta.setTipo(cuentaDto.getTipo());
        cuenta.setNumero(cuentaDto.getNumero());
        cuenta.setTipo(cuentaDto.getTipo());
        Cliente cliente = new Cliente();
        cliente.setApellido(clienteDto.getApellido());
        cliente.setPaisNacimiento(clienteDto.getPaisNacimiento());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setCedula(clienteDto.getCedula());
        cuenta.setCliente(cliente);
        cuentaRepository.save(cuenta);
    }

    public void eliminarCuenta(int cuentaId){

        cuentaRepository.deleteCuenta(cuentaId);

    }


}
