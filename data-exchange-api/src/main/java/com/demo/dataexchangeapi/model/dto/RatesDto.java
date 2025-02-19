package com.demo.dataexchangeapi.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RatesDto {
    private String code;
    private String currency;
    private BigDecimal bid;
    private BigDecimal ask;
}
