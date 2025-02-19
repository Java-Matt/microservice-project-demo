package com.demo.dataexchangeapi.controller;

import com.demo.dataexchangeapi.model.dto.RequestDto;
import com.demo.dataexchangeapi.model.dto.ResultDto;
import com.demo.dataexchangeapi.model.dto.RatesDto;
import com.demo.dataexchangeapi.model.dto.ShortRatesDto;
import com.demo.dataexchangeapi.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/currencies")
public class CurrencyController {
    private final CurrencyService service;

    @GetMapping
    public List<ShortRatesDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{code}")
    public RatesDto getSymbol(@PathVariable String code) {
        return service.findByCode(code);
    }

    @GetMapping("/convert")
    @PreAuthorize("hasRole('client_admin')")
    public ResultDto convert(RequestDto request){
        return service.convert(request);
    }

    @GetMapping("/convertConfirmation")
    @PreAuthorize("hasRole('client_user')")
    public ResultDto convertConfirmation(RequestDto request){
        return service.convertWithConfirmation(request);
    }

    @GetMapping("/test")
    @PreAuthorize("hasRole('client_user')")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/hello-2")
    @PreAuthorize("hasRole('client_admin')")
    public String hello2() {
        return "Hello - Admin";
    }
}
