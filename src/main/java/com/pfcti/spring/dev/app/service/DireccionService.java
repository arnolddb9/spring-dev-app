package com.pfcti.spring.dev.app.service;

import com.pfcti.spring.dev.app.repository.DireccionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DireccionService {
    private DireccionRepository direccionRepository;
}
