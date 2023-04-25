package com.pfcti.spring.dev.app.beans;

import com.pfcti.spring.dev.app.dto.ClienteDto;
import com.pfcti.spring.dev.app.dto.ClienteQueryDto;
import com.pfcti.spring.dev.app.dto.enums.ClienteQueryType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
class BuscadorClientesBDTest {
    @Autowired
    @Qualifier("sistemaDB")
    BuscadorClientes buscadorClientes;

    @Autowired
    BuscadorClientes sistemaExterno;



    @Test
    void obtenerListaClientes() {


        //AdministradorClientes administradorClientes= new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
        ClienteQueryDto clienteQueryDto= new ClienteQueryDto();
        clienteQueryDto.setTextoBusqueda("PEREZ");
        clienteQueryDto.setClienteQueryType(ClienteQueryType.NOMBRES);

        List<ClienteDto> clienteDtos =  buscadorClientes.obtenerListaClientes(clienteQueryDto);
        clienteDtos.forEach( clienteDto -> {System.out.println("Cliente "+ clienteDto.getApellido());});
        assertTrue(clienteDtos.size()==1);
    }

    @Test
    void obtenerListaClientes2() {


        ClienteQueryDto clienteQueryDto= new ClienteQueryDto();
        clienteQueryDto.setTextoBusqueda("PEREZ");
        clienteQueryDto.setClienteQueryType(ClienteQueryType.NOMBRES);

        List<ClienteDto> clienteDtos =  sistemaExterno.obtenerListaClientes(clienteQueryDto);
        clienteDtos.forEach( clienteDto -> {System.out.println("Cliente "+ clienteDto.getApellido());});


        assertTrue(clienteDtos.size() == 0);
    }
}