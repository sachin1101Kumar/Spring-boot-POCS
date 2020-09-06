package com.currencyconversion.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.currencyconversion.bean.Exchange;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<Exchange, Long> {
     Exchange findByFromAndTo(String from,String to);
}
