package com.example.lab.repository;

import com.example.lab.Model.Cuenta;
import com.example.lab.Model.Inversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InversionRepository extends JpaRepository<Inversion,Integer> {
}
