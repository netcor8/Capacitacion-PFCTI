package com.demo.services;

import com.demo.repository.DireccionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DireccionService {
    private DireccionRepository direccionRepository;
}
