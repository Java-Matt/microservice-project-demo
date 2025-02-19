package com.demo.dataexchangeapi.service;

import com.demo.dataexchangeapi.model.dto.NotificationDto;
import com.demo.dataexchangeapi.properties.RabbitProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationSenderService {
    private final RabbitTemplate rabbitTemplate;
    private final RabbitProperties properties;

    public void send(NotificationDto notificationDto) {
        rabbitTemplate.convertAndSend(properties.getRatesQueueName(), notificationDto);
        log.info("sent: {}", notificationDto);
    }
}
