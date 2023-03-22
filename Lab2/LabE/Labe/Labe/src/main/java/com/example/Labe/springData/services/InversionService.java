package com.example.Labe.springData.services;

import com.example.Labe.springData.repository.InversionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InversionService {
    private InversionRepository inversionRepository;
}
