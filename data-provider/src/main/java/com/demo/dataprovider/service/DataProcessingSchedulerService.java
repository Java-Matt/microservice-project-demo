package com.demo.dataprovider.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DataProcessingSchedulerService {
    private final DataProcessingService dataProcessingService;

    @Scheduled(cron = "0 */1 * * * *")
    public void startProcessing() {
        log.info("processing started");
        dataProcessingService.process();
    }
}
