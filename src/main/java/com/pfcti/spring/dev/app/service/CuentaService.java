package com.pfcti.spring.dev.app.service;

import com.pfcti.spring.dev.app.repository.CuentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CuentaService {
    private CuentaRepository cuentaRepository;
}
