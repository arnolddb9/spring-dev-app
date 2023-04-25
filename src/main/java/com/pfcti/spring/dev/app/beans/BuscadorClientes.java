package com.pfcti.spring.dev.app.beans;

import com.pfcti.spring.dev.app.dto.ClienteDto;
import com.pfcti.spring.dev.app.dto.ClienteQueryDto;

import java.util.List;

public interface BuscadorClientes {
    List<ClienteDto> obtenerListaClientes(ClienteQueryDto clienteQueryDto);

}
