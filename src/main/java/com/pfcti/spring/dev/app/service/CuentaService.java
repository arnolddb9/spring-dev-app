package com.pfcti.spring.dev.app.service;

import com.pfcti.spring.dev.app.criteria.CuentaSpecification;
import com.pfcti.spring.dev.app.dto.ClienteDto;
import com.pfcti.spring.dev.app.dto.CuentaDto;
import com.pfcti.spring.dev.app.model.Cliente;
import com.pfcti.spring.dev.app.model.Cuenta;
import com.pfcti.spring.dev.app.repository.CuentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CuentaService {
    private CuentaRepository cuentaRepository;
    private CuentaSpecification cuentaSpecification;


    public List<Cuenta> buscarDinamicamentePorCriteriaDeBusqueda(CuentaDto cuentaDtoFilter){
        return cuentaRepository
                .findAll(cuentaSpecification.buildFilter(cuentaDtoFilter));
    }

    public void updateCuentaEstadoByNumeroQuery(String numero){

        cuentaRepository.updateCuentaEstadoByNumeroQuery(numero);
    }

    public List<CuentaDto>findCuentaByCliente_Id (int id){
        List<CuentaDto> cuentaDtos = new ArrayList<>();
        List<Cuenta> cuentas =  cuentaRepository.findCuentaByCliente_Id(id);
        cuentas.forEach(cuenta -> {
            cuentaDtos.add(fromCuentaToCuentaDto(cuenta));
        });
        return cuentaDtos;
    }

    public void insertarCuenta(CuentaDto cuentaDto, int idCliente) {
        Cliente cliente= new Cliente();
        cliente.setId(idCliente);
        Cuenta cuenta = new Cuenta();
        //cuenta.setId(cuentaDto.getId());
        cuenta.setTipo(cuentaDto.getTipo());
        cuenta.setNumero(cuentaDto.getNumero());
        cuenta.setCliente(cliente);
        cuenta.setEstado(cuentaDto.getEstado());

        cuentaRepository.save(cuenta);
    }

    private CuentaDto fromCuentaToCuentaDto(Cuenta cuenta) {
        CuentaDto cuentaDto = new CuentaDto();
        BeanUtils.copyProperties(cuenta, cuentaDto);
        return cuentaDto;
    }
}
