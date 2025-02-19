package com.demo.dataprovider.client;

import com.demo.dataprovider.model.RatesTableDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "currencyApiClient", url = "${nbp.api.base-url}")
public interface NbpApiClient {
    @GetMapping("/tables/C")
    List<RatesTableDto> getAllCurrencies();
}
