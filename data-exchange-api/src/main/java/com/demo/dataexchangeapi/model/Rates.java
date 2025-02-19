package com.demo.dataexchangeapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rates {
    @Id
    private String code;
    private String currency;
    private BigDecimal bid;
    private BigDecimal ask;
}
