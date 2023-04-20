package com.pfcti.spring.dev.app.service;

import com.pfcti.spring.dev.app.repository.InversionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InversionService {
    private InversionRepository inversionRepository;
}
