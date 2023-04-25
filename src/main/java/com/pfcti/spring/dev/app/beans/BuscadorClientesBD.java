package com.pfcti.spring.dev.app.beans;

import com.pfcti.spring.dev.app.dto.ClienteDto;
import com.pfcti.spring.dev.app.dto.ClienteQueryDto;
import com.pfcti.spring.dev.app.dto.enums.ClienteQueryType;
import com.pfcti.spring.dev.app.model.Cliente;
import com.pfcti.spring.dev.app.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("sistemaDB")
public class BuscadorClientesBD implements BuscadorClientes{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDto> obtenerListaClientes(ClienteQueryDto clienteQueryDto){
        List<Cliente> clientes = null;
        List<ClienteDto> clienteDto = new ArrayList<>();
        if (ClienteQueryType.CEDULA.equals(clienteQueryDto.getClienteQueryType())) {
            clientes = clienteRepository.findClientesByCedula(clienteQueryDto.getTextoBusqueda());

        } else if (ClienteQueryType.NOMBRES.equals(clienteQueryDto.getClienteQueryType())) {
            clientes = clienteRepository.findClientesByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(clienteQueryDto.getTextoBusqueda(), clienteQueryDto.getTextoBusqueda());
        }

        clientes.forEach(cliente -> {
            clienteDto.add(fromClienteToClienteDto(cliente));
        });
        return clienteDto;
    }

    private ClienteDto fromClienteToClienteDto(Cliente cliente) {
        ClienteDto clienteDto = new ClienteDto();
        BeanUtils.copyProperties(cliente, clienteDto);
        return clienteDto;
    }
}
