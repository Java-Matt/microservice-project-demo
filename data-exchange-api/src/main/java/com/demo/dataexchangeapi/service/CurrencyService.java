package com.demo.dataexchangeapi.service;

import com.demo.dataexchangeapi.exceptions.CurrencyNotFoundException;
import com.demo.dataexchangeapi.mapper.RatesMapper;
import com.demo.dataexchangeapi.model.AuthData;
import com.demo.dataexchangeapi.model.Rates;
import com.demo.dataexchangeapi.model.dto.*;
import com.demo.dataexchangeapi.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository repository;
    private final RatesMapper mapper;
    private final NotificationSenderService notificationSenderService;
    private final AuthDataService authDataService;

    public List<ShortRatesDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::mapToShortDto)
                .toList();
    }

    public RatesDto findByCode(String code) {
        return repository.findByCode(code).map(mapper::mapToDto)
                .orElseThrow(() -> new CurrencyNotFoundException(MessageFormat
                        .format("Currency {0} not found", code)));
    }

    public ResultDto convert(RequestDto request) {
        Rates from = repository.findByCode(request.getFrom()).orElseThrow(() -> new CurrencyNotFoundException(MessageFormat
                .format("Currency {0} not found", request.getFrom())));
        Rates to = repository.findByCode(request.getTo()).orElseThrow(() -> new CurrencyNotFoundException(MessageFormat
                .format("Currency {0} not found", request.getTo())));
        BigDecimal exchangeRate = from.getAsk().divide(to.getBid(), RoundingMode.DOWN);
        ResultDto result = new ResultDto();
        result.setFrom(from.getCode());
        result.setTo(to.getCode());
        result.setAmount(request.getAmount());
        result.setExchangeRate(exchangeRate);
        result.setResult(request.getAmount().multiply(exchangeRate));
//        mailInfoQueueSender(result);
        return result;
    }

    public ResultDto convertWithConfirmation(RequestDto request) {
        ResultDto result = convert(request);
        AuthData authData = authDataService.getAuthData();
        mailInfoQueueSender(result, authData.getEmail());
        return result;
    }

    private void mailInfoQueueSender(ResultDto result, String email) {
        notificationSenderService.send(new NotificationDto(result, email));
    }
}
