package com.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "direccion")
@Getter
@Setter
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30)
    private String direccion;
    @Column(length = 30)
    private String nomenclatura;
    @ManyToOne
    @JoinColumn(name ="cliente_id", referencedColumnName = "id")
    private Cliente cliente;
}
