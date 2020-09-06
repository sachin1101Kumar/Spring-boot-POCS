package com.currencyexchange.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currencyexchange.beans.Exchange;
import com.currencyexchange.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@GetMapping("/currencyexchange/{currency}/{from}/to/{to}")
	public Exchange getCurrencyExchangeValue(@PathVariable("currency") BigDecimal currency,@PathVariable("from") String from,@PathVariable("to") String to ) {
		return	currencyExchangeService.findByFromAndTo(from, to,currency);
	}
}
