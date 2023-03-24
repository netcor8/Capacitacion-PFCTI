package com.example.Labe.springData.repository;

import  com.example.Labe.springData.model.Cliente;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Integer>, JpaSpecificationExecutor<Cliente> {
    List<Cliente> findClientesByPaisNacimientoAndCuentas_EstadoIsTrue(String paisNacimiento);

    @Query(value = "select c from Cliente c where c.apellido = :apellido")
    List<Cliente> buscarPorApellido(String apellido);

    @Query(value = "select nombre,apellido,cedula,telefono,id from cliente where apellido = :apellido",
            nativeQuery = true)
    List<Tuple>  buscarPorApellidoNativo(String apellido);

    @Query(value = "select * from CLIENTE C inner join TARJETA C2 on C.ID = C2.CLIENTE_ID where PAIS_NACIMIENTO <> 'CR' and C2.ESTADO = false",
            nativeQuery = true)
    List<Tuple>  buscarClienteExtranjerosPorTarjeta_Inactiva();


    List<Cliente> findByCedula(String cedula);

    List<Cliente> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombres, String apellido);

}
