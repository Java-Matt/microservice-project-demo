package com.demo.durabilityservice.listener;

import com.demo.durabilityservice.model.dto.RatesDto;
import com.demo.durabilityservice.service.RatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {
    private final RatesService service;

    @RabbitListener(queues = "${rabbit.rates-queue-name}")
    public void receiveMessage(RatesDto ratesDto) {
        service.saveRates(ratesDto);
    }
}
