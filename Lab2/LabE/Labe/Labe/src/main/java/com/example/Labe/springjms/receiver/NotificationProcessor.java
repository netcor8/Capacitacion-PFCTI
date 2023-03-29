package com.example.Labe.springjms.receiver;


import com.example.Labe.springjms.dto.NotificationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationProcessor {

    @JmsListener(destination = "smsReceiverJms")
    public void processMessage(NotificationDto notificationDto){
        log.info("sms info:  {}", notificationDto );
    }

}
