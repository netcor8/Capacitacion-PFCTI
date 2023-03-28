package com.example.Labe.reactive.repository;

import com.example.Labe.reactive.model.Empleado;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface EmpleadoRepository extends ReactiveMongoRepository<Empleado,Integer> {

    @Query("{'name':  ?0}")
    Flux<Empleado> findByName(final String name);
}
