package com.example.lab.Service;

import com.example.lab.DTO.ClienteDto;
import com.example.lab.Model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;


    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void insertarCliente() {
        List<Cliente> clienteList = entityManager.createQuery("SELECT c FROM Cliente c").getResultList();
        System.out.println("listar antes de insertar: " + clienteList);
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setApellido("Cordero");
        clienteDto.setNombre("Ernesto");
        clienteDto.setCedula("123456789");
        clienteDto.setTelefono("123456789");
        clienteService.insertarCliente(clienteDto);
        clienteList = entityManager.createQuery("SELECT c FROM Cliente c").getResultList();
        assertFalse(clienteList.isEmpty());
        System.out.println("Cuantos tiene: " + clienteList.size());
        assertEquals("123456789",clienteList.get(5).getCedula());
    }

    @Test
    void ObtenerCliente() {
        ClienteDto clienteDto = clienteService.obtenerCliente(1);
        System.out.println("El cliente es " + clienteDto.getNombre() + "" + clienteDto.getApellido());
        assertEquals(1,clienteDto.getId());

    }

    @Test
    void actualizarCliente() {
        //INSERT INTO CLIENTE (APELLIDOS, CEDULA, NOMBRE, TELEFONO) VALUES ('PEREZ', '1', 'ROBERTO', '093939393');

        ClienteDto clienteDtoBase = clienteService.obtenerCliente(1);
        System.out.println(clienteDtoBase);

        clienteDtoBase.setNombre(clienteDtoBase.getNombre() + "TEST");
        clienteDtoBase.setCedula(clienteDtoBase.getCedula() + "TEST");
        clienteDtoBase.setTelefono(clienteDtoBase.getTelefono() + "TEST");
        clienteDtoBase.setApellido(clienteDtoBase.getApellido() + "TEST");
        clienteService.actualizarCliente(clienteDtoBase);

        ClienteDto clienteDtoBaseUpdated = clienteService.obtenerCliente(1);

        System.out.println(clienteDtoBaseUpdated);
        assertEquals("ROBERTOTEST", clienteDtoBaseUpdated.getNombre());
        assertEquals("PEREZTEST", clienteDtoBaseUpdated.getApellido());
    }

    @Test
    void eliminarCliente() {
        ClienteDto clienteDto = clienteService.obtenerCliente(1);
        assertEquals(1, clienteDto.getId());
        clienteService.eliminarCliente(1);
        try {
            clienteService.obtenerCliente(1);
            fail("No debe llegar acá");    }
        catch (RuntimeException e){
            System.out.println("CLIENTE NO EXISTE: " + e.getMessage());
        }
    }

    @Test
    void obtenerClientesPorCodigoISOPaisYCuentasActivas() {
        List<ClienteDto> clientesDto = clienteService.obtenerClientesPorCodigoISOPaisYCuentasActivas("CR");
        clientesDto.forEach(clienteDto -> {System.out.println("Cuentas Activas" + clienteDto);});
        assertEquals(1, clientesDto.size());
    }

    @Test
    void buscarClientesPorApellido() {
        List<Cliente> cliente =  clienteService.buscarClientesPorApellido("PEREZ");
        assertFalse(cliente.isEmpty());
        assertEquals("PEREZ", cliente.get(0).getApellidos());
    }


    @Test
    void reportPorTipoClienteYCuenta() {
        List<ClienteDto> clientesDto = clienteService.obtenerClientesPorCodigoISOPaisYCuentasActivas("EXTRANJERO");
        clientesDto.forEach(clienteDto -> {System.out.println("Cuentas Extranjeras" + clienteDto);});
        assertEquals(1, clientesDto.size());
    }


    @Test
    void buscarClientesDinamicamentePorCriterio() {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setApellido("SANCHEZ");
        clienteDto.setNombre("RAUL");
        List<ClienteDto> resultadoCriteriosConDatosDTO = clienteService.buscarClientesDinamicamentePorCriterio(clienteDto);
        resultadoCriteriosConDatosDTO.forEach(clienteDtoResultado -> {System.out.println("ClienteDto es:"+ clienteDtoResultado);});
        assertEquals(1,resultadoCriteriosConDatosDTO.size());
    }
}