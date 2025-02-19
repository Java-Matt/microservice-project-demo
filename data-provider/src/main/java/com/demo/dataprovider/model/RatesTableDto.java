package com.demo.dataprovider.model;

import lombok.Data;

import java.util.List;

@Data
public class RatesTableDto {
    private String table;
    private String no;
    private String tradingDate;
    private String effectiveDate;
    private List<RatesDto> rates;
}
