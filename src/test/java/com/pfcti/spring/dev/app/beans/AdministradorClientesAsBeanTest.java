package com.pfcti.spring.dev.app.beans;

import com.pfcti.spring.dev.app.dto.ClienteDto;
import com.pfcti.spring.dev.app.dto.ClienteQueryDto;
import com.pfcti.spring.dev.app.dto.enums.ClienteQueryType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AdministradorClientesAsBeanTest {

    @Autowired
    private AdministradorClientes defaultNombreSingleton;

    @Autowired
    @Qualifier("defaultNombre")
    private AdministradorClientes administradorClientes;

    @Test
    void obtenerListaClientesPorCriterio() {
        ClienteQueryDto clienteQueryDto = new ClienteQueryDto();
        clienteQueryDto.setTextoBusqueda("ROBERTO");
        clienteQueryDto.setClienteQueryType(ClienteQueryType.NOMBRES);

        List<ClienteDto> clienteDtos = defaultNombreSingleton.obtenerListaClientesPorCriteria(clienteQueryDto);
        clienteDtos.forEach(clienteDto -> {
            System.out.println("Cliente: " + clienteDto.getApellido());
        });
        assertTrue(clienteDtos.size() == 1);
    }

    @Test
    void obtenerListaClientesPorCriterioConAnotacion() {
        ClienteQueryDto clienteQueryDto = new ClienteQueryDto();
        clienteQueryDto.setTextoBusqueda("ROBERTO");
        clienteQueryDto.setClienteQueryType(ClienteQueryType.NOMBRES);

        List<ClienteDto> clienteDtos = administradorClientes.obtenerListaClientesPorCriteria(clienteQueryDto);
        clienteDtos.forEach(clienteDto -> {
            System.out.println("Cliente: " + clienteDto.getApellido());
        });
        assertTrue(clienteDtos.size() == 1);
    }
}
