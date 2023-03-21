package com.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "inversion")
@Getter
@Setter
public class Inversion {
    @Id
    private int id;
    private String numero;
    private String tipo;
    @ManyToOne
    @JoinColumn(name ="cliente_id", referencedColumnName = "id")
    private Cliente cliente;
}
