package com.pfcti.spring.dev.app.service;

import com.pfcti.spring.dev.app.dto.ClienteDto;
import com.pfcti.spring.dev.app.dto.CuentaDto;
import com.pfcti.spring.dev.app.model.Cuenta;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CuentaServiceTest {

    @Autowired
    private CuentaService cuentaService;
    @Test
    void buscarDinamicamentePorCriteriaDeBusqueda() {
        CuentaDto cuentaDto1 = new CuentaDto();
        cuentaDto1.setEstado(true);
        List<Cuenta> cuentas= cuentaService.buscarDinamicamentePorCriteriaDeBusqueda(cuentaDto1);
        cuentas.forEach(cuenta -> {
            System.out.println("Cuenta; "+ cuenta.getNumero()+" " + cuenta.getEstado());
        });

        cuentaDto1 = new CuentaDto();
        cuentaDto1.setNumero("33333");
        List<Cuenta> cuentas1= cuentaService.buscarDinamicamentePorCriteriaDeBusqueda(cuentaDto1);
        cuentas1.forEach(cuenta -> {
            System.out.println("Cuenta; "+ cuenta.getNumero()+" " + cuenta.getEstado());
        });

        cuentaDto1 = new CuentaDto();
        cuentaDto1.setTipo("AHORRO");
        List<Cuenta> cuentas2= cuentaService.buscarDinamicamentePorCriteriaDeBusqueda(cuentaDto1);
        cuentas2.forEach(cuenta -> {
            System.out.println("Cuenta; "+ cuenta.getNumero()+" " + cuenta.getEstado());
        });

        assertTrue(cuentas2.size()<=2);

    }
}