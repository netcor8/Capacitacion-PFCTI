package com.example.Labe.springData.services;

import com.example.Labe.springData.repository.DireccionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DireccionService {
    private DireccionRepository direccionRepository;
}
