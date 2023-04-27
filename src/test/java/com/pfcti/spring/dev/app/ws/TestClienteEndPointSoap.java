package com.pfcti.spring.dev.app.ws;

import io.spring.guides.gs_producing_web_service.GetClienteRequest;
import io.spring.guides.gs_producing_web_service.GetClienteResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.ClassUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestClienteEndPointSoap {
    private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

    @LocalServerPort
    private int port = 0;


    @BeforeEach
    public void init() throws Exception {
        marshaller.setPackagesToScan(ClassUtils.getPackageName(GetClienteRequest.class));
        marshaller.afterPropertiesSet();
    }

    @Test
    public void testSendAndReceive() {
        WebServiceTemplate ws = new WebServiceTemplate(marshaller);
        GetClienteRequest request = new GetClienteRequest();
        request.setId(2);
        GetClienteResponse response = (GetClienteResponse) ws.marshalSendAndReceive("http://localhost:"
                + port + "/ws", request);
        System.out.println("response :" + response.getCliente());
        System.out.println("response :" + response.getCliente().getNombre());
        assertThat(response != null);
        assertThat(response.getCliente() != null);
    }

}
