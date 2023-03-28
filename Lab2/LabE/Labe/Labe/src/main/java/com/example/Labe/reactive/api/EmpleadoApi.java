package com.example.Labe.reactive.api;


import com.example.Labe.reactive.model.Empleado;
import com.example.Labe.reactive.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/api/empleado")
public class EmpleadoApi {

    @Autowired
  private EmpleadoService empleadoService;

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public void create(@RequestBody Empleado empleado){
       empleadoService.create(empleado);
   }

   @GetMapping("/{id}")
    public ResponseEntity<Mono<Empleado>> findById(@PathVariable("id") Integer id){
       Mono<Empleado> empleadoMono = empleadoService.findById(id);
       return new ResponseEntity<Mono<Empleado>>(empleadoMono, HttpStatus.OK);
   }

   @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Empleado> findAll(){
       return empleadoService.findAll();
   }

   @GetMapping("/name/{name}")

    public Flux<Empleado> findByName(@PathVariable("name") String name ){
       return empleadoService.findByName(name);
   }

   @PutMapping("/update")
   @ResponseStatus(HttpStatus.OK)
    public Mono<Empleado> update (@RequestBody Empleado empleado){
       return empleadoService.update(empleado);
   }

   @DeleteMapping("/delete/{id}")
   @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") Integer id){
       empleadoService.delete(id).subscribe() ;
   }

}
