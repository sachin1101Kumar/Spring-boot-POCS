package com.currencyexchange.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.currencyexchange.beans.Exchange;
import com.currencyexchange.repository.CurrencyExchangeRepository;
import com.currencyexchange.response.CurrencyConversionServiceResponse;

@Service
public class CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment environment;
	
	public Exchange findByFromAndTo(String from,String to,BigDecimal amount) {
		Map<String, String> uriVariables=new HashMap<String, String>();
		Exchange exchange=new Exchange();
		uriVariables.put("from", from);
		uriVariables.put("to",to);
		uriVariables.put("amount",String.valueOf(amount));

		ResponseEntity<CurrencyConversionServiceResponse> currencyConversionResponse=restTemplate.getForEntity("http://localhost:8100/convertCurrency/from/{from}/to/{to}/{amount}", CurrencyConversionServiceResponse.class, uriVariables);

		if(currencyConversionResponse.getBody()!=null) {
			CurrencyConversionServiceResponse res=currencyConversionResponse.getBody();
			exchange.setConvertedAmount(res.getExchange().getConvertedAmount());
			exchange.setCurrency(amount);
			exchange.setFrom(res.getExchange().getFrom());
			exchange.setTo(res.getExchange().getTo());
			exchange.setPort(res.getExchange().getPort());
		}
		return  exchange;
	}
	
}
