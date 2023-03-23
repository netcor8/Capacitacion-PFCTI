package com.example.Labe.springbeans;

import com.example.Labe.springbeans.business.BuscardorCuentas;
import com.example.Labe.springbeans.dto.CuentaQueryDto;
import com.example.Labe.springbeans.dto.CuentaQueryType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class AdministradorCuentasTest {


    @Autowired
    @Qualifier("sistemaExternocuentas")
    private BuscardorCuentas buscadorCuentas;

    @Test
    void setCuentaRepository() {
    }

    @Test
    void obtieneListaCuentasSistemExterno() {
        var criteria = new CuentaQueryDto();
        criteria.setTextoBusqueda("2");
        criteria.setTipoBusqueda(CuentaQueryType.clienteId);
        var cuentas = buscadorCuentas.obtenerListaCuentas(criteria);
        System.out.println("Numero de Cuentas: " + cuentas.size());
        Assert.isTrue(cuentas.size() == 1, "Se esperaban 1 cuentas");
    }

}