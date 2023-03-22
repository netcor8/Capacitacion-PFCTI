package com.example.Labe.springData.repository;


import com.example.Labe.springData.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarjetaRepository  extends JpaRepository <Tarjeta, Integer>, JpaSpecificationExecutor<Tarjeta> {

    @Query(value = "select * from Tarjeta c where c.CLIENTE_ID = :id", nativeQuery = true)
    List<Tarjeta> findByCliente_Id(int id);
}
