package com.example.Labe.services;

import com.example.Labe.springData.dto.TarjetaDto;
import com.example.Labe.springData.model.Tarjeta;
import com.example.Labe.springData.services.TarjetaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TarjetaServiceTest {
    @Autowired
    private TarjetaService tarjetaService;
    @Test
    void cambiarEstadoTarjetaPorId() {
        TarjetaDto tarjetaDto = new TarjetaDto();
        tarjetaDto.setId(1);
        tarjetaDto.setEstado(false);
        tarjetaService.cambiarEstadoTarjetaPorId(tarjetaDto);
        assertEquals(false, tarjetaDto.getEstado());
    }
}