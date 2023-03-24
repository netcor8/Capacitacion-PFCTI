package com.example.Labe.springWeb;


import com.example.Labe.springData.dto.ClienteDto;
import com.example.Labe.springData.services.ClienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/api/cliente")
@Slf4j
public class clienteApi {

    @Autowired

    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ClienteDto buscarCliente(@PathVariable int id){
        log.info("Busqueda de Cliente; {}", id);
        return clienteService.obtenerCliente(id);
    }


    @GetMapping(value = "/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ClienteDto buscarClienteXML(@PathVariable int id){
        log.info("Busqueda de Cliente; {}", id);
        return clienteService.obtenerCliente(id);
    }


    @GetMapping(value = "/xml/json/{id}", produces ={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ClienteDto buscarClienteXMLJson(@PathVariable int id){
        log.info("Busqueda de Cliente; {}", id);
        return clienteService.obtenerCliente(id);
    }

    @GetMapping(value = "/parameter", produces =MediaType.APPLICATION_JSON_VALUE)
    public ClienteDto buscarClienteParametro(@RequestParam int id){
        log.info("Busqueda de Cliente; {}", id);
        return clienteService.obtenerCliente(id);
    }



    @PostMapping
    public void guardarCliente(@Valid @RequestBody ClienteDto clienteDto){
        log.info("Busqueda de Cliente; {}", clienteDto);
        clienteService.insertarCliente(clienteDto);
    }

    @GetMapping(value = "/all")
    public List<ClienteDto> buscarTodosClientes(){

       return clienteService.obtenerTodosClientes();
    }

    @PutMapping
    public void ActualizarCliente(@RequestBody ClienteDto clienteDto){
        log.info("Busqueda de Cliente; {}", clienteDto);
        clienteService.actualizarCliente(clienteDto);
    }

    @DeleteMapping(value="/{id}")
    public void eliminarCliente(@PathVariable int clienteId){
        log.info("Busqueda de Cliente; {}", clienteId);
        clienteService.eliminarCliente(clienteId);
    }





}
