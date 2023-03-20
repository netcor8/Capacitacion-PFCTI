package com.example.lab.Service;

import com.example.lab.repository.TarjetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TarjetaService {
    TarjetaRepository tarjetaRepository;
}
