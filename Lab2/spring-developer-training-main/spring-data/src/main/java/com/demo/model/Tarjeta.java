package com.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tarjeta")
@Getter
@Setter
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;
    private String tipo;
    @ManyToOne
    @JoinColumn(name ="cliente_id", referencedColumnName = "id")
    private Cliente cliente;
    private Boolean estado; // activo/desactivo
}
