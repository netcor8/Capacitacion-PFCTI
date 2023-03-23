package com.example.Labe.springbeans.config;

import com.example.Labe.springData.repository.ClienteRepository;
import com.example.Labe.springbeans.AdministradorClientes;
import com.example.Labe.springbeans.dto.ClienteQueryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class beanConfiguration {

    @Autowired
    private ClienteRepository clienteRepository;

    @Bean
    public AdministradorClientes administradorClientes(){

        return new AdministradorClientes(clienteRepository, ClienteQueryType.CEDULA);
    }

    @Bean({"defaultCedula", "criteriaByCedula"})//Si tiene mas de un nombre para usarlo
    public AdministradorClientes administradorClientesBean(){

        return new AdministradorClientes(clienteRepository, ClienteQueryType.CEDULA);
    }


    @Bean("defaultNombres")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Lazy
    public AdministradorClientes administradorClientesBeanP() {

        return new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
    }


    @Bean("defaultNombresPrototype")
    @Lazy
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public AdministradorClientes administradorClientesBeanPrototype() {

        return new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
    }


    //Si se un nombre va de esta manera
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Lazy
    public AdministradorClientes administradorClientesPrototype() {
        //Puede tener lógica adicional si es necesario
        //Se devuelve la instacia del objeto que se desea exponer como Bean
        return new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
    }



    @Bean("defaultNombresSession")
    @SessionScope
    @Lazy
    public AdministradorClientes administradorClientesBeanSession() {

        return new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
    }


    @Bean("defaultNombresSession")
    @RequestScope
    @Lazy
    public AdministradorClientes administradorClientesBeanRequest() {

        return new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
    }

    @Bean("defaultNombresSession")
    @ApplicationScope
    @Lazy
    public AdministradorClientes administradorClientesBeanApplication() {

        return new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
    }

}
