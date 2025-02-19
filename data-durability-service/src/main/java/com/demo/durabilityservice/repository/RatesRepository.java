package com.demo.durabilityservice.repository;

import com.demo.durabilityservice.model.Rates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatesRepository extends JpaRepository<Rates, Integer> {
}
