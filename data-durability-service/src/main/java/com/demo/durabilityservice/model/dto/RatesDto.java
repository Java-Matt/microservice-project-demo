package com.demo.durabilityservice.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RatesDto {
    private String currency;
    private String code;
    private BigDecimal bid;
    private BigDecimal ask;
}
