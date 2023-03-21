package com.example.lab.repository;

import com.example.lab.Model.Cliente;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>, JpaSpecificationExecutor<Cliente> {

    List<Cliente> findClientesByPaisNacimientoAndCuentas_EstadoIsTrue(String paisNacimiento);


    @Query(value = "select c from Cliente c where c.apellidos = :apellidos")
    List<Cliente> buscarPorApellidos(String apellidos);

    @Query(value = "select nombre,apellidos,cedula,telefono,id from cliente where apellidos := apellidos",
            nativeQuery = true)
    List<Tuple>  buscarPorApellidosNativo(String apellidos);


    @Query("SELECT c FROM Cliente c INNER JOIN Tarjeta t ON c = t.cliente WHERE c.pais = :tipoCliente AND t.estado = false")
    List<Tuple>  reportPorTipoClienteYCuenta(String tipoCliente);






}
