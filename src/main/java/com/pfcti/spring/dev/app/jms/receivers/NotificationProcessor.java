package com.pfcti.spring.dev.app.jms.receivers;

import com.pfcti.spring.dev.app.dto.NotificationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationProcessor {

    //smsReceiverJms, va a representar el nombre de la cola donde se está escuchando
    @JmsListener(destination = "smsReceiverJms")
    public void processMessage(NotificationDto notificationDto) {
        //Lógica para envío de sms.
        log.info("sms info:{}", notificationDto);
    }

}
