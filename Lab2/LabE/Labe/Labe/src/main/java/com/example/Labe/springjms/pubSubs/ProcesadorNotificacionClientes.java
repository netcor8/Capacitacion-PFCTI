package com.example.Labe.springjms.pubSubs;


import com.example.Labe.springData.dto.CuentaDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class ProcesadorNotificacionClientes {



     @ServiceActivator(inputChannel = "pubSubNotification")
      public Message<String> consumirMensajeParaCLientes(Message<CuentaDto> message){

          CuentaDto cuentaDto = message.getPayload();
          return MessageBuilder.withPayload("Mensaje recibido por ProcesdorNotificacionClientes ").build();
      }

}
