package com.pfcti.spring.dev.app.soap;

import com.pfcti.spring.dev.app.model.Cliente;
import com.pfcti.spring.dev.app.repository.ClienteRepository;
import com.pfcti.spring.dev.app.service.ClienteService;
import io.spring.guides.gs_producing_web_service.GetClienteRequest;
import io.spring.guides.gs_producing_web_service.GetClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ClienteEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @Autowired
    private ClienteService clienteService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClienteRequest")
    @ResponsePayload
    public GetClienteResponse obtenerCliente(@RequestPayload GetClienteRequest request) {
        GetClienteResponse response = new GetClienteResponse();
        response.setCliente(clienteService.obtenerClienteSoap(request.getId()));
        return response;
    }


}
