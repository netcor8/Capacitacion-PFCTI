package com.example.lab.Criterio;

import com.example.lab.DTO.ClienteDto;
import com.example.lab.Model.Cliente;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;

@Component
public class ClienteSpecification {

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

    private Specification<Cliente> apellidoCriteria(ClienteDto clientDto){
      return like ("apellido", clientDto.getApellido());

    }

    private Specification<Cliente> nombreCriteria(ClienteDto clientDto){
        return like ("nombre", clientDto.getNombre());
    }

    private Specification<Cliente> cedulaCriteria(ClienteDto clientDto){
        return like ("cedula", clientDto.getCedula());
    }

    private Specification<Cliente> telefonoCriteria(ClienteDto clientDto){
        return like ("telefono", clientDto.getTelefono());
    }

    private Specification<Cliente> paisCriteria(ClienteDto clientDto){
        return like ("pais", clientDto.getPais());
    }


    public Specification<Cliente> buildFilter(ClienteDto clienteDto){
        System.out.println("Cliente criteria: " + clienteDto);
        return Specification.where(apellidoCriteria(clienteDto))
                .and(nombreCriteria(clienteDto))
                .and(cedulaCriteria(clienteDto))
                .and(telefonoCriteria(clienteDto))
                .and(paisCriteria(clienteDto));
    }

}