package com.currencyconversion.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CURRENCY_CONVERSION")
public class Exchange {
    @Id
	private long id;
    
    @Column(name="currency_from")
    private String from;
    
    @Column(name="currency_to")
    private String to;
    
    @Column(name="convertion_rate")
    private BigDecimal convertionRate;
    
    @Column(name="converted_amount")
    private BigDecimal convertedAmount;
    
    @Column(name="port")
    private int port;

    public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Exchange() {
	}

	public Exchange(long id, String from, String to, BigDecimal convertionRate, BigDecimal convertedAmount) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.convertionRate = convertionRate;
		this.convertedAmount = convertedAmount;
	}
	
	public BigDecimal getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(BigDecimal convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	public long getId() {
		return id;
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
	public BigDecimal getConvertionRate() {
		return convertionRate;
	}
	public void setConvertionRate(BigDecimal convertionRate) {
		this.convertionRate = convertionRate;
	}
	@Override
	public String toString() {
		return "Exchange [id=" + id + ", from=" + from + ", to=" + to + ", convertionRate=" + convertionRate + "]";
	}
}
