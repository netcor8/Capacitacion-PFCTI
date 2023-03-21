package com.demo.repository;

import com.demo.model.Cliente;
import com.demo.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer>, JpaSpecificationExecutor<Cuenta> {
    void deleteAllByCliente_Id(int clienteId);

    @Query(value = "select * from Cuenta c where c.CLIENTE_ID = :id", nativeQuery = true)
    List<Cuenta> findByCliente_Id(int id);

}
