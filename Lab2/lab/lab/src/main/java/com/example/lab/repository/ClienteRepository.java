package com.example.lab.repository;

import com.example.lab.Model.Cliente;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>
        , JpaSpecificationExecutor<Cliente> {
    @Query("SELECT t FROM Cliente t INNER JOIN Cuenta c ON t = c.cliente WHERE t.pais = :pais AND c.estado")
    public List<Cliente>  obtenerClientesCuentasActivas(String pais);


    //Derived methods
    public List<Cliente> obtenerClientesPorPaisCuentasEstadoActivo(String pais);

    @Query("SELECT c FROM Cliente c WHERE c.apellidos like %:apellido%")
    public List<Cliente> obtieneClientesPorApellidoQueryLanguage(String apellido);

    @Query(value = "SELECT nombre,apellidos,cedula,telefono,id FROM Cliente WHERE apellidos like %:apellido%"
            , nativeQuery = true)
    public List<Tuple> obtieneClientesPorApellidoQueryLanguageNativeQuery(String apellido);


    @Query("SELECT c FROM Cliente c INNER JOIN Tarjeta t ON c = t.cliente WHERE c.pais != :codigoPaisLocal AND t.estado = false")
    public List<Cliente> obtieneClientesExtrajerosConTarjetasInactivas(String codigoPaisLocal);

    public List<Cliente>    obtenerClientesPorPaisConEstadoInactivo(String paisNacimiento);
}
