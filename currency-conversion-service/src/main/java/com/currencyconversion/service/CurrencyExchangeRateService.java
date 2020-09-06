package com.currencyconversion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currencyconversion.bean.Exchange;
import com.currencyconversion.respository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeRateService {

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	public Exchange fetchByFromAndTo(String from,String to){
		return currencyExchangeRepository.findByFromAndTo(from, to);
	}
	
}
