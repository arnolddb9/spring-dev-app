package com.pfcti.spring.dev.app.service;

import com.pfcti.spring.dev.app.dto.ClienteDto;
import com.pfcti.spring.dev.app.model.Cliente;
import com.pfcti.spring.dev.app.repository.*;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;
    private CuentaRepository cuentaRepository;
    private TarjetaRepository tarjetaRepository;
    private InversionRepository inversionRepository;
    private DireccionRepository direccionRepository;

    public void insertarCliente(ClienteDto clienteDto) {

        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setCedula(clienteDto.getCedula());
        cliente.setTelefono(clienteDto.getTelefono());
        clienteRepository.save(cliente);
    }

    public ClienteDto obtenerCliente(int clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> {
                            throw new RuntimeException("Cliente no existe");
                        }
                );
        ClienteDto clienteDto = new ClienteDto();
        clienteDto = fromClienteToClienteDto(cliente);

        return clienteDto;
    }

    public void actualizarCliente(ClienteDto clienteDto) {

        Cliente cliente = clienteRepository.findById(clienteDto.getId())
                .orElseThrow(() -> {
                            throw new RuntimeException("Cliente no existe");
                        }
                );

        cliente.setId(clienteDto.getId());
        cliente.setNombre(cliente.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setCedula(clienteDto.getCedula());
        cliente.setTelefono(clienteDto.getTelefono());
        clienteRepository.save(cliente);

    }

    public List<ClienteDto> obtenerClientes() {
        List<ClienteDto> clienteDtos = new ArrayList<>();
        List<Cliente> clientes = clienteRepository.findAll();
        clientes.forEach(cliente -> {
            clienteDtos.add(fromClienteToClienteDto(cliente));
        });
        return clienteDtos;
    }

    public void eliminarCliente(int clienteId) {
        direccionRepository.deleteAllByCliente_id(clienteId);
        cuentaRepository.deleteAllByCliente_id(clienteId);
        inversionRepository.deleteAllByCliente_id(clienteId);
        tarjetaRepository.deleteAllByCliente_id(clienteId);
        clienteRepository.deleteById(clienteId);

    }

    private ClienteDto fromClienteToClienteDto(Cliente cliente) {
        ClienteDto clienteDto = new ClienteDto();
        BeanUtils.copyProperties(cliente, clienteDto);
        return clienteDto;
    }

    public List<ClienteDto> obtenerClientesPorCosigoISOPaisYCuentasActivas(String codigoISOPais) {
        List<ClienteDto> clienteDtos = new ArrayList<>();
        List<Cliente> clientes = clienteRepository.findClientesByPaisAndCuentas_EstadoIsTrue(codigoISOPais);
        clientes.forEach(cliente -> {
            clienteDtos.add(fromClienteToClienteDto(cliente));
        });
        return clienteDtos;
    }
    public List<ClienteDto> buscarPorApellido (String apellido){
        List<ClienteDto> clienteDtos= new ArrayList<>();
        List<Cliente> clientes= clienteRepository.buscarPorApellido(apellido);
        clientes.forEach(cliente -> {
            clienteDtos.add(fromClienteToClienteDto(cliente));
        });
        return clienteDtos;
    }

    public List<ClienteDto> buscarPorApellidosQueryNativo (String apellido){
        List<ClienteDto> clienteDtos= new ArrayList<>();
        List<Tuple> tuples= clienteRepository.buscarPorApellidosQueryNativo(apellido);
        tuples.forEach(tuple -> {
            ClienteDto clienteDto = new ClienteDto();
            clienteDto.setApellido((String) tuple.get("apellido"));
            clienteDto.setNombre((String) tuple.get("nombre"));
            clienteDto.setCedula((String) tuple.get("cedula"));
            clienteDto.setTelefono((String) tuple.get("telefono"));
            clienteDto.setId((Integer) tuple.get("id"));
            clienteDtos.add(clienteDto);
        });
        return clienteDtos;
    }

    public void updateClienteByQuery (String nombre,String apellido){
        clienteRepository.updateClienteByQuery(nombre,apellido);
    }

    public List<ClienteDto> findByApellidoAndNombre (String apellido, String nombre){
        return clienteRepository
                .findByApellidoAndNombre(apellido,nombre)
                .stream()
                .map(this::fromClienteToClienteDto)
                .collect(Collectors.toList());
    }

}
