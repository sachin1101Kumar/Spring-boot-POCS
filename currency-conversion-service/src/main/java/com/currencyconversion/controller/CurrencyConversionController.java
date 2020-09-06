package com.currencyconversion.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currencyconversion.bean.Exchange;
import com.currencyconversion.response.CurrencyConversionServiceResponse;
import com.currencyconversion.service.CurrencyExchangeRateService;

@RestController
public class CurrencyConversionController {

	@Autowired
	private ConversionService conversionService;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeRateService currencyExchangeRateService; 
	
	@Autowired
	private CurrencyConversionServiceResponse CurrencyConversionResponse;
	
	@GetMapping("/convertCurrency/from/{from}/to/{to}/{amount}")
	public CurrencyConversionServiceResponse fetchConversionRate(@PathVariable("from") String from,
			                            @PathVariable("to") String to,
			                            @PathVariable("amount") String amount) {
		
          		Exchange exchange=currencyExchangeRateService.fetchByFromAndTo(from, to);
          		BigDecimal enteredAmount=new BigDecimal(amount);
          	    BigDecimal convertedAmount=(enteredAmount.multiply(exchange.getConvertionRate()));
          	    exchange.setConvertedAmount(convertedAmount);
          	    exchange.setPort(Integer.valueOf(env.getProperty("local.server.port")));
            
          	  CurrencyConversionResponse.setExchange(exchange);
          	    
          	return CurrencyConversionResponse;
          	    
	}
	
}
