package com.currencyexchange.beans;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exchange_Currency")
public class Exchange {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private BigDecimal currency;
	@Column(name="currency_from")
	private String from;
	@Column(name="currency_to")
	private String to;
	@Column
	private int port;
	@Column
	private BigDecimal convertedAmount;
	
	public BigDecimal getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(BigDecimal convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	public Exchange() {
	}

	public Exchange(BigDecimal currency, String from, String to, int port, BigDecimal convertedAmount) {
		this.currency = currency;
		this.from = from;
		this.to = to;
		this.port = port;
		this.convertedAmount = convertedAmount;
	}

	public BigDecimal getCurrency() {
		return currency;
	}

	public void setCurrency(BigDecimal currency) {
		this.currency = currency;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "Exchange [currency=" + currency + ", from=" + from + ", to=" + to + ", port=" + port
				+ ", convertedAmount=" + convertedAmount + "]";
	}
}
