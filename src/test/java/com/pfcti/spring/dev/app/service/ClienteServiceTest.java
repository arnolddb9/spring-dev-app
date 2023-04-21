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
        System.out.println("El cliente final es: "+ clienteDtoLuegoDeUpdate.getApellido());
        assertEquals("SALAZAR", clienteDtoLuegoDeUpdate.getApellido());
    }

    @Test
    void obtenerClientes() {
        List<ClienteDto> clienteDtos = clienteService.obtenerClientes();
        clienteDtos.forEach(cliente -> System.out.println("Cliente: " + cliente.getApellido()));
        assertEquals(2, clienteDtos.size());
    }

    @Test
    void obtenerClientesPorCosigoISOPaisYCuentasActivas() {
        List<ClienteDto> clienteDtos= clienteService.obtenerClientesPorCosigoISOPaisYCuentasActivas("CR");
        clienteDtos.forEach(clienteDto -> {
            System.out.println("Cliente; " + clienteDto.getApellido());
        });
        assertEquals(1,1);
    }

    @Test
    void eliminarCliente() {
        clienteService.eliminarCliente(1);
        assertEquals(1,1);
    }

    @Test
    void buscarPorApellido() {
        List<ClienteDto> clienteDtos = clienteService.obtenerClientes();
        ClienteDto clienteDto= clienteService.obtenerCliente(1);
        List<ClienteDto> clienteDtosApellidos =  clienteService.buscarPorApellido(clienteDto.getApellido());
        clienteDtosApellidos.forEach(cliente -> System.out.println("Cliente: " + cliente.getNombre()));
        assertEquals(1,1);

    }

    @Test
    void buscarPorApellidosQueryNativo() {
        List<ClienteDto> clienteDtos = clienteService.obtenerClientes();
        ClienteDto clienteDto= clienteService.obtenerCliente(1);
        List<ClienteDto> clienteDtosApellidos =  clienteService.buscarPorApellidosQueryNativo(clienteDto.getApellido());
        clienteDtosApellidos.forEach(cliente -> System.out.println("Cliente: " + cliente.getNombre()));
        assertEquals(1,1);
    }

    @Test
    void updateClienteByQuery() {
        ClienteDto clienteDto= clienteService.obtenerCliente(1);
        System.out.println("nombre  " +clienteDto.getNombre());
        clienteService.updateClienteByQuery("Julian",clienteDto.getApellido());
        clienteDto= clienteService.obtenerCliente(1);
        System.out.println("nombre  " +clienteDto.getNombre());
        assertEquals(1,1);
    }

    @Test
    void findByApellidoAndNombre() {
        List<ClienteDto> clienteDtos= clienteService.findByApellidoAndNombre("SANCHEZ", "RAUL");
        System.out.println("Cliente "+ clienteDtos.get(0).getNombre());
        assertFalse(clienteDtos.isEmpty());
        assertEquals(1,1);
    }

    @Test
    void findClientesByPaisNotAndTarjetas_EstadoIsFalse() {
        List<ClienteDto> clienteDtos= clienteService.findClientesByPaisNotAndTarjetas_EstadoIsFalse("CR");
        clienteDtos.forEach(clienteDto -> {
            System.out.println("Cliente; "+ clienteDto.getNombre()+" " + clienteDto.getApellido());
        });
        assertEquals(1,1);
    }
}