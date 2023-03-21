package com.example.lab.Service;

import com.example.lab.Model.Tarjeta;
import com.example.lab.repository.TarjetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TarjetaService {
    TarjetaRepository tarjetaRepository;

    public void cambiarEstadoTarjetaPorId(int id){
        Tarjeta tarjeta = tarjetaRepository.findById(id).orElseThrow();

    }

}
