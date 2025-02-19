package com.demo.dataexchangeapi.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestDto {
    private String from;
    private String to;
    private BigDecimal amount;
}
