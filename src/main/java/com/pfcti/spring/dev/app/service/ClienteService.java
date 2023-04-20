package com.pfcti.spring.dev.app.service;

import com.pfcti.spring.dev.app.dto.ClienteDto;
import com.pfcti.spring.dev.app.model.Cliente;
import com.pfcti.spring.dev.app.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;

    public void insertarCliente(ClienteDto clienteDto){


        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setCedula(clienteDto.getCedula());
        cliente.setTelefono(clienteDto.getTelefono());

        clienteRepository.save(cliente);
    }

    public ClienteDto obtenerCliente (int clienteId){
        Cliente cliente= clienteRepository.findById(clienteId)
                .orElseThrow(()-> {
            throw  new RuntimeException("Cliente no existe");
        }
                );
        ClienteDto clienteDto= new ClienteDto();
//        /*clienteDto.setId(cliente.getId());
//        clienteDto.setNombre(cliente.getNombre());
//        clienteDto.setApellido(cliente.getApellido());
//        clienteDto.setCedula(cliente.getCedula());
//        clienteDto.setTelefono(cliente.getTelefono());*/

        clienteDto=fromClienteToClienteDto(cliente);

        return clienteDto;
    }

    public void actualizarCliente(ClienteDto clienteDto){

        Cliente cliente= clienteRepository.findById(clienteDto.getId())
                .orElseThrow(()-> {
                            throw  new RuntimeException("Cliente no existe");
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

    public String eliminarCliente(ClienteDto clienteDto){

        Cliente cliente = new Cliente();
        cliente.setId(clienteDto.getId());
        cliente.setNombre(cliente.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setCedula(clienteDto.getCedula());
        cliente.setTelefono(clienteDto.getTelefono());

        clienteRepository.delete(cliente);

        return "Se elimino con exito";
    }

    private ClienteDto fromClienteToClienteDto(Cliente cliente){
        ClienteDto clienteDto = new ClienteDto();
        BeanUtils.copyProperties(cliente,clienteDto);
//        /*clienteDto.setId(cliente.getId());
//        clienteDto.setNombre(cliente.getNombre());
//        clienteDto.setApellidos(cliente.getApellidos());
//        clienteDto.setCedula(cliente.getCedula());
//        clienteDto.setTelefono(cliente.getTelefono());*/
        return clienteDto;
    }

   // public ClienteDto buscarClientePorID(int id){

   // }
}
