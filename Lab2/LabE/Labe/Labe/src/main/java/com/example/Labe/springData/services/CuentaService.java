package com.example.Labe.springData.services;

import com.example.Labe.springData.criteria.CuentaSpecification;
import com.example.Labe.springData.dto.ClienteDto;
import  com.example.Labe.springData.dto.CuentaDto;
import com.example.Labe.springData.model.Cliente;
import  com.example.Labe.springData.model.Cuenta;
import com.example.Labe.springData.repository.CuentaRepository;
import com.example.Labe.springjms.dto.NotificationDto;
import com.example.Labe.springjms.pubSubs.publicadores.NotificationPubSubSender;
import com.example.Labe.springjms.sender.NotificationSender;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
//@Transactional
public class CuentaService {
    private CuentaRepository cuentaRepository;
    private CuentaSpecification cuentaSpecification;

    private NotificationSender notificationSender;

    private ClienteService clienteService;


    private NotificationPubSubSender notificationPubSubSender;

    private CuentaDto fromCuentaToDto(Cuenta cuenta){
        CuentaDto cuentaDto = new CuentaDto();
        BeanUtils.copyProperties(cuenta, cuentaDto);
        return cuentaDto;
    }

    public List<CuentaDto> buscarCuentasDinamicamentePorCriterio(CuentaDto cuentaDtoFilter){
        return cuentaRepository.findAll(cuentaSpecification.buildFilter(cuentaDtoFilter))
                .stream().map(this::fromCuentaToDto).collect(Collectors.toList());
    }

    public List<CuentaDto> buscarCuentasPorCliente(int idCliente) {
        List<CuentaDto> cuentasPorCliente = new ArrayList<>();
        cuentaRepository.findCuentasByCliente_IdAndEstadoIsTrue(idCliente)
                .stream()
                .map(cuenta -> {
                    cuentasPorCliente.add(fromCuentaToDto(cuenta));
                    //  log.info("Cuenta de Cliente :{}", cuenta);
                    return cuenta;}
                ).collect(Collectors.toList());
        return cuentasPorCliente;
    }

    public void insertarCuenta (CuentaDto cuentaDto){
        Cuenta cuenta = new Cuenta();
        cuenta.setTipo(cuentaDto.getTipo());
        cuenta.setNumero(cuentaDto.getNumero());
        cuenta.setTipo(cuentaDto.getTipo());
        cuentaDto.setClienteId(cuentaDto.getClienteId());
        cuentaRepository.save(cuenta);
        this.enviarNotificacion(cuentaDto);


    }

    private void enviarNotificacion(CuentaDto cuentaDto){
        NotificationDto notificationDto = new NotificationDto();
        ClienteDto clienteDto = clienteService.obtenerCliente(cuentaDto.getClienteId());
        notificationDto.setPhoneNumber(clienteDto.getTelefono());
        notificationDto.setMailBody("Estimado " + clienteDto.getNombre() + "tu cuenta fue creada");
        notificationSender.sendSms(notificationDto);
        Message<CuentaDto> message = MessageBuilder.withPayload(cuentaDto).build();
        notificationPubSubSender.sendNotification(message);
    }



    public CuentaDto desactivarCuentaPorId(CuentaDto cuentaDto){
        Cuenta cuenta = cuentaRepository.findById(cuentaDto.getId()).orElseThrow(() -> {throw new RuntimeException("cuenta de Cliente No Existe");});
        cuenta.setEstado(false);
        cuentaRepository.save(cuenta);
        return fromCuentaToDto(cuenta);
    }



}
