package com.example.Labe.springData.services;

import com.example.Labe.springData.model.Tarjeta;
import com.example.Labe.springData.dto.TarjetaDto;
import com.example.Labe.springData.repository.TarjetaRepository;
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
