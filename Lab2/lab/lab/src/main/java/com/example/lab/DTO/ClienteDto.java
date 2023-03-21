package com.example.lab.DTO;

import com.example.lab.Model.Cuenta;
import com.example.lab.Model.Direccion;
import com.example.lab.Model.Inversion;
import com.example.lab.Model.Tarjeta;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClienteDto {
    private int id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;

    private String pais;

    private String tipo;

    private List<Direccion> direccionesDto ;

    private List<Cuenta> cuentasDto = new ArrayList<>();
    private List<Tarjeta> tarjetasDto = new ArrayList<>();
    private List<Inversion> inversionesDto = new ArrayList<>();


}
