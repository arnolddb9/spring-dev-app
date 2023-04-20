package com.pfcti.spring.dev.app.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClienteDto {

    private int id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private List<DireccionDto> direcciones;
}
