package com.currencyexchange.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.currencyexchange.beans.Exchange;

@Repository
public interface CurrencyExchangeRepository extends CrudRepository<Exchange, Long> {
	Exchange findByFromAndTo(String from,String to);
}
