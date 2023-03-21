package com.example.lab.repository;

import com.example.lab.Model.Cliente;
import com.example.lab.Model.Cuenta;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta,Integer>, JpaSpecificationExecutor<Cuenta> {

    void deleteAllByCliente_id(int clienteid);




}

