package com.example.Labe.springData.services;

import com.example.Labe.springData.criteria.CuentaSpecification;
import  com.example.Labe.springData.dto.CuentaDto;
import  com.example.Labe.springData.model.Cuenta;
import com.example.Labe.springData.repository.CuentaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
}
