package com.example.Labe.springbeans;

import com.example.Labe.springData.dto.ClienteDto;
import com.example.Labe.springData.dto.CuentaDto;
import com.example.Labe.springData.model.Cliente;
import com.example.Labe.springData.repository.ClienteRepository;
import com.example.Labe.springData.repository.CuentaRepository;
import com.example.Labe.springbeans.dto.ClienteQueryDto;
import com.example.Labe.springbeans.dto.ClienteQueryType;
import com.example.Labe.springbeans.dto.CuentaQueryDto;
import com.example.Labe.springbeans.dto.CuentaQueryType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class AdministradorCuentas {

    public void setCuentaRepository(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    private  CuentaRepository cuentaRepository;

    private CuentaQueryType defaultCuentaQueryType;



    public AdministradorCuentas(CuentaRepository cuentaRepositoryi , CuentaQueryType cuentaQueryType) {
        System.out.println("Inicializando Constructor: " + this);
        this.cuentaRepository = cuentaRepository;
        this.defaultCuentaQueryType = cuentaQueryType;
    }




    public AdministradorCuentas(CuentaQueryType cuentaQueryType) {
       // this.clienteRepository = clienteRepository;
        this.defaultCuentaQueryType = cuentaQueryType;
    }



    public List<CuentaDto> obtieneListaCuentasPorCliente(CuentaQueryDto queryDto) {

        var cuentas = List.of(
                new CuentaDto(1, "12345", "EFEC", true,1),
                new CuentaDto(2, "123456", "EFEC", true,2),
                new CuentaDto(3, "123457", "EFEC", true,3),
                new CuentaDto(4, "12345678", "EFEC", true,4),
                new CuentaDto(5, "12345679", "EFEC", true,5),
                new CuentaDto(6, "12345670", "EFEC", true,6)
        );
        return cuentas.stream().filter(filter ->
                        filter.getClienteId() == queryDto.getClienteId() &&
                                filter.getNumero().contains(queryDto.getTextoBusqueda()))
                .toList();

    }
}
