package com.demo.dataexchangeapi.mapper;

import com.demo.dataexchangeapi.model.Rates;
import com.demo.dataexchangeapi.model.dto.RatesDto;
import com.demo.dataexchangeapi.model.dto.ShortRatesDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RatesMapper {

    RatesDto mapToDto(Rates rates);

    ShortRatesDto mapToShortDto(Rates rates);

}
