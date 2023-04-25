package com.pfcti.spring.dev.app.beans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdministradorClientesScopeTest {

    @Autowired
    @Qualifier("defaultCedula")
    private AdministradorClientes singleton1;

    @Autowired
    @Qualifier("defaultNombreSingleton")
    private AdministradorClientes singleton2;

    @Autowired
    @Qualifier("defaultNombreSingleton")
    private AdministradorClientes singleton3;
    @Test
    void instancia(){
        System.out.println("singleton 1 "+ singleton1);
        System.out.println("singleton 2 "+ singleton2);
        System.out.println("singleton 3 "+ singleton3);

    }
}
