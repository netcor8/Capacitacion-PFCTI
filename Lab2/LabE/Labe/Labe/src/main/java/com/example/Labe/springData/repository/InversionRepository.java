package com.example.Labe.springData.repository;

import com.example.Labe.springData.model.Inversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InversionRepository extends JpaRepository<Inversion, Integer> {
}

