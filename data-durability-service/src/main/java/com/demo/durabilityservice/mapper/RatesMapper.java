package com.demo.durabilityservice.mapper;

import com.demo.durabilityservice.model.Rates;
import com.demo.durabilityservice.model.dto.RatesDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RatesMapper {
    Rates mapFromDto(RatesDto ratesTableDto);
}
