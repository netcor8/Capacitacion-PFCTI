package com.demo.repository;

import com.demo.model.Cliente;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Integer>, JpaSpecificationExecutor<Cliente> {
    List<Cliente> findClientesByPaisNacimientoAndCuentas_EstadoIsTrue(String paisNacimiento);

    @Query(value = "select c from Cliente c where c.apellidos = :apellidos")
    List<Cliente> buscarPorApellidos(String apellidos);

    @Query(value = "select nombre,apellidos,cedula,telefono,id from cliente where apellidos = :apellidos",
            nativeQuery = true)
    List<Tuple>  buscarPorApellidosNativo(String apellidos);

    @Query(value = "select * from CLIENTE C inner join TARJETA C2 on C.ID = C2.CLIENTE_ID where PAIS_NACIMIENTO <> 'CR' and C2.ESTADO = false",
            nativeQuery = true)
    List<Tuple>  buscarClienteExtranjerosPorTarjeta_Inactiva();


}
