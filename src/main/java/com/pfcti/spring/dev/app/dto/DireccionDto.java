package com.pfcti.spring.dev.app.dto;

import lombok.Data;

@Data
public class DireccionDto {
    private int id;
    private String direccion;
    private String nomeclatura;
    private int clienteId;

}
