package com.currencyexchange.response;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CurrencyConversionServiceResponse {

	public Exchange exchange;
	public List<Exchange> exchangeList;
	
	public CurrencyConversionServiceResponse() {
	}
	
	public CurrencyConversionServiceResponse(Exchange exchange, List<Exchange> exchangeList) {
		this.exchange = exchange;
		this.exchangeList = exchangeList;
	}
	public Exchange getExchange() {
		return exchange;
	}
	public void setExchange(Exchange exchange) {
		this.exchange = exchange;
	}
	public List<Exchange> getExchangeList() {
		return exchangeList;
	}
	public void setExchangeList(List<Exchange> exchangeList) {
		this.exchangeList = exchangeList;
	}
}
