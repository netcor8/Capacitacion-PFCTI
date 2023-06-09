package com.example.Labe.springData.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import java.util.List;
@Entity
@Table(name = "cliente")
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    @NotNull(message = "Name cannot be null")
    private String nombre;
    @Column(length = 30)
    private String apellido;
    @Column(columnDefinition = "varchar(9)")
    private String cedula;
    private String telefono;

    private boolean estado;

    private String paisNacimiento;

    @OneToMany(mappedBy = "cliente")
    private List<Cuenta> cuentas;

    @OneToMany(mappedBy = "cliente")
    private List<Direccion> direccions;

}
