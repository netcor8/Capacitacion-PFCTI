package com.example.Labe.springbeans;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AdministradorClientesScopeTest

{

    @Autowired
    @Qualifier("defaultNombres")
    private AdministradorClientes single;

    @Autowired
    @Qualifier("defaultNombresPrototype")
    private AdministradorClientes prototype1;

    @Autowired
    @Qualifier("defaultNombres")
    private AdministradorClientes singleton1;

    @Autowired
    @Qualifier("defaultNombres")
    private AdministradorClientes singleton2;
    @Autowired
    @Qualifier("defaultNombresPrototype")
    private AdministradorClientes prototype2;
    @Autowired
    @Qualifier("defaultNombresPrototype")
    private AdministradorClientes prototype3;


    @Test
    void instancias() {
        System.out.println("singleton1 " + singleton1);
        System.out.println("singleton2 " + singleton2);
        System.out.println("prototype1 " + prototype1);
        System.out.println("prototype2 " + prototype2);
        Assertions.assertEquals(1, 1);
    }


}
