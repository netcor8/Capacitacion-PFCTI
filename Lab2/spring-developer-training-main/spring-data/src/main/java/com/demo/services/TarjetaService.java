package com.demo.services;

import com.demo.model.Tarjeta;
import com.demo.dto.TarjetaDto;
import com.demo.repository.TarjetaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class TarjetaService {
    private TarjetaRepository tarjetaRepository;

    public TarjetaDto cambiarEstadoTarjetaPorId(TarjetaDto tarjetaDto){
        Tarjeta tarjeta = tarjetaRepository.findById(tarjetaDto.getId()).orElseThrow(()-> {throw new RuntimeException("Clinete no Existe");});
        tarjeta.setEstado(tarjetaDto.getEstado());
        tarjetaRepository.save(tarjeta);
        return null;
    }
}
