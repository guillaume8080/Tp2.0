package com.tactfactory.microservice.currencyconversionservice;


import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {
private Logger logger=LoggerFactory.getLogger(this.getClass());
@Autowired
private CurrencyExchangeServiceProxy proxy;
@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
@PathVariable BigDecimal quantity) {
CurrencyConversion response = proxy.convertCurrencyFeign(from, to);
CurrencyConversion result = new CurrencyConversion(response.getId(), from, to,
response.getConversionMultiple(), quantity,
quantity.multiply(response.getConversionMultiple()), response.getPort());
logger.info("{}", result);
return result;
}
}

