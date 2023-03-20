package com.example.lab.repository;

import com.example.lab.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

    List<Cliente> findClientesByPaisNacimientoAndCuentas_EstadoIsTrue(String paisNacimiento);



}
