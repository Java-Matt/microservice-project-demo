package com.demo.durabilityservice.service;

import com.demo.durabilityservice.mapper.RatesMapper;
import com.demo.durabilityservice.model.dto.RatesDto;
import com.demo.durabilityservice.repository.RatesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RatesService {
    private final RatesRepository ratesRepository;
    private final RatesMapper ratesMapper;

    @Transactional
    public void saveRates(RatesDto ratesDto) {
        ratesRepository.save(ratesMapper.mapFromDto(ratesDto));
    }
}
