package com.example.Labe.springjms.sender;

import com.example.Labe.springjms.dto.NotificationDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationSender {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendSms(NotificationDto notificationDto){
        log.info("Enviando sms a la cola {} con numero de telefono", notificationDto.getPhoneNumber());
        jmsTemplate.convertAndSend("smsReceiverJms", notificationDto);
    }

}
