package com.example.lab.Criterio;

import com.example.lab.DTO.ClienteDto;
import com.example.lab.DTO.CuentaDto;
import com.example.lab.Model.Cliente;
import com.example.lab.Model.Cuenta;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;

@Component
public class CuentaSpecification
{

    public <T> Specification<T> equals(String fieldName, String fieldValue) {
        return fieldValue == null ? null :
                (root, query, criteriaBuilder)
                        -> criteriaBuilder.equal(root.get(fieldName), fieldValue);
    }

    public static <T> Specification<T> like(String fieldName, String fieldValue) {
        if (fieldValue != null) {
            String uppercaseValue = MessageFormat.format("%{0}%", fieldValue.trim().toUpperCase(Locale.ROOT)).replaceAll(" ", "%");
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.like(criteriaBuilder.upper(root.get(fieldName)), uppercaseValue);
        } else {
            return null;
        }
    }

    private Specification<Cuenta> numeroCriteria(CuentaDto cuentaDto){
        return like ("numero", cuentaDto.getNumero());

    }

    private Specification<Cuenta> tipoCriteria(CuentaDto cuentaDto){
        return like ("tipo", cuentaDto.getTipo());

    }

    private Specification<Cuenta> estadoCriteria(CuentaDto cuentaDto){
        return like ("estado", cuentaDto.getEstado().toString());

    }

    public Specification<Cuenta> buildFilter(CuentaDto cuentaDto){
        System.out.println("Cuenta of criteria: " + cuentaDto);
       /* return Specification.where(numeroCriteria(cuentaDto))
                .and(nombreCriteria(clienteDto))
                .and(cedulaCriteria(clienteDto))
                .and(telefonoCriteria(clienteDto))
                .and(paisCriteria(clienteDto));*/
        return null;
    }





}
