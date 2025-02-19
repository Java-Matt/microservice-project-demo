package com.demo.dataprovider.service;

import com.demo.dataprovider.client.NbpApiClient;
import com.demo.dataprovider.model.RatesTableDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DataProcessingService {
    private final NbpApiClient nbpApiClient;
    private final DataSenderService dataSenderService;

    public void process() {
        log.info("processing...");
        nbpApiClient.getAllCurrencies().stream()
                .map(RatesTableDto::getRates)
                .flatMap(List::stream)
                .forEach(dataSenderService::send);
    }
}
