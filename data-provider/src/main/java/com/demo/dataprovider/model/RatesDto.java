package com.demo.dataprovider.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RatesDto {
    private String currency;
    private String code;
    private BigDecimal bid;
    private BigDecimal ask;
}
