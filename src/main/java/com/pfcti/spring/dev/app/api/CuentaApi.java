package com.pfcti.spring.dev.app.api;

import com.pfcti.spring.dev.app.dto.ClienteDto;
import com.pfcti.spring.dev.app.dto.CuentaDto;
import com.pfcti.spring.dev.app.service.ClienteService;
import com.pfcti.spring.dev.app.service.CuentaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/api/cuenta")
public class CuentaApi {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/{idCliente}")
    public List<CuentaDto> buscarCuentaPorClienteId(@PathVariable int idCliente){
        log.info("Busqueda de cliente : {}", idCliente);
        return cuentaService.findCuentaByCliente_Id(idCliente);
    }
    @PutMapping
    public void actualizarEstadoCuenta(@RequestBody String cuenta) {
        log.info("cuenta de cliente : {}", cuenta);
        cuentaService.updateCuentaEstadoByNumeroQuery(cuenta);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void guardarCuenta(@Valid @RequestBody CuentaDto cuentaDto){
        log.info("cuenta a guardar: {}", cuentaDto);
        cuentaService.insertarCuenta(cuentaDto);
    }

}
