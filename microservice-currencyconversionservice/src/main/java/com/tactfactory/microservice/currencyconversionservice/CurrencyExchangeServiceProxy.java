package com.tactfactory.microservice.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	CurrencyConversion convertCurrencyFeign(@PathVariable("from") String from, @PathVariable("to") String to);
}
