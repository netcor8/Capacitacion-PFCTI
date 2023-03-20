package com.example.lab.repository;

import com.example.lab.Model.Inversion;
import com.example.lab.Model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta,Integer> {
}
