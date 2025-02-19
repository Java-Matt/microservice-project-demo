package com.demo.dataexchangeapi.repository;

import com.demo.dataexchangeapi.model.Rates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Rates, Integer> {
    Optional<Rates> findByCode(String code);
}
