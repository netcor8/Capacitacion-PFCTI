package com.example.Labe.springWeb;


import com.example.Labe.springData.dto.ClienteDto;
import com.example.Labe.springData.dto.CuentaDto;
import com.example.Labe.springData.services.ClienteService;
import com.example.Labe.springData.services.CuentaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/cuenta")
@Slf4j
public class cuentaApi {


    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/{id}")
    public List<CuentaDto> consultarCuentesXCliente(@PathVariable int id){
        log.info("Busqueda de ClienteID; {}", id);
        return cuentaService.buscarCuentasPorCliente(id);
    }

    @PostMapping
    public void guardarCuentas(@RequestBody CuentaDto cuentaDto){
        log.info("Busqueda de Cliente; {}", cuentaDto);
        cuentaService.insertarCuenta(cuentaDto);
    }

    @DeleteMapping(value="/{id}")
    public void DesactivarCuenta(@PathVariable CuentaDto cuentaDto){
        log.info("Busqueda de Cliente; {}", cuentaDto);
        cuentaService.desactivarCuentaPorId(cuentaDto);
    }

}
