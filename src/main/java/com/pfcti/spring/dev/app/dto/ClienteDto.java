package com.pfcti.spring.dev.app.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.util.List;

@Data
public class ClienteDto {

    private int id;
    @NotNull
    @Size(max = 10)
    private String nombre;
    private String apellido;
    @NotNull
    @Size(max = 13)
    private String cedula;
    private String telefono;
    private String pais;
    private List<DireccionDto> direcciones;
    private List<CuentaDto> cuentaDtos;
}
