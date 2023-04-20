package com.pfcti.spring.dev.app.service;

import com.pfcti.spring.dev.app.dto.ClienteDto;
import com.pfcti.spring.dev.app.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void insertarCliente() {

        List<Cliente> listClientes= entityManager.createQuery("SELECT c from Cliente c").getResultList();
        System.out.println("Lista de cleintes "+ listClientes.size());

        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNombre("Arnold");
        clienteDto.setApellido("Duran");
        clienteDto.setCedula("20607");
        clienteDto.setTelefono("1234567");
        clienteService.insertarCliente(clienteDto);

        listClientes= entityManager.createQuery("SELECT c from Cliente c").getResultList();
        System.out.println("Lista de cleintes "+ listClientes.size());


        assertEquals(1, 1);
    }


    @Test
    void obtenerCliente() {
        ClienteDto clienteDto= clienteService.obtenerCliente(1);
        System.out.println("cliente "+ clienteDto.getNombre());
        assertEquals(1,1);
    }

    @Test
    void actualizarCliente() {

        ClienteDto clienteDtoInicial = clienteService.obtenerCliente(1);
        System.out.println("El cliente inicial es: "+ clienteDtoInicial.getApellido());
        clienteDtoInicial.setApellido("SALAZAR");
        clienteService.actualizarCliente(clienteDtoInicial);
        ClienteDto clienteDtoLuegoDeUpdate = clienteService.obtenerCliente(1);
        System.out.println("El cliente inicial es: "+ clienteDtoLuegoDeUpdate.getApellido());
        assertEquals("SALAZAR", clienteDtoLuegoDeUpdate.getApellido());
    }

    @Test
    void obtenerClientes() {
        clienteService.obtenerClientes().stream().map(
                cliente ->{
                    System.out.println(">>>>>>> Cliente :" + cliente.getApellido());
                    return cliente;
                }
        ).collect(Collectors.toList());
        assertEquals(1,1);
    }
}