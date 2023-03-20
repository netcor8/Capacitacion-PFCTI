package com.example.lab.Service;


import com.example.lab.repository.CuentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CuentaService {
    CuentaRepository CuentaRepository;
}
