package com.demo.dataprovider.service;

import com.demo.dataprovider.model.RatesDto;
import com.demo.dataprovider.properties.RabbitProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DataSenderService {
    private final RabbitTemplate rabbitTemplate;
    private final RabbitProperties properties;

    public void send(RatesDto ratesDto) {
        log.info("sent: {}", ratesDto);
        rabbitTemplate.convertAndSend(properties.getRatesQueueName(), ratesDto);
    }
}
