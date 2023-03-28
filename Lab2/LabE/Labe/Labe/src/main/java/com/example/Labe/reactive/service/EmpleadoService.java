package com.example.Labe.reactive.service;


import com.example.Labe.reactive.model.Empleado;
import com.example.Labe.reactive.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmpleadoService {

    @Autowired
   EmpleadoRepository empleadoRepository;

    public void create(Empleado empleado){
        empleadoRepository.save(empleado);
    }


   public Mono<Empleado> findById(Integer id){
        return  empleadoRepository.findById(id);
   }

   public Flux<Empleado> findByName(String name){
        return empleadoRepository.findByName(name);
   }

   public Flux<Empleado> findAll(){
        return empleadoRepository.findAll();
   }

   public Mono<Empleado> update(Empleado empleado){
        return empleadoRepository.save(empleado);
   }

   public Mono<Void> delete (Integer id){
        return empleadoRepository.deleteById(id);
   }


}
