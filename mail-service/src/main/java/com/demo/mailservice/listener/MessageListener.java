package com.demo.mailservice.listener;

import com.demo.mailservice.dto.NotificationDto;
import com.demo.mailservice.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {
    private final EmailService service;

    @RabbitListener(queues = "${rabbit.rates-queue-name}")
    public void receiveMessage(NotificationDto convertNotificationDto) {
        service.sendMail(convertNotificationDto);
    }
}
