package com.ryandemo.microservices.currencyconverterservice.bean;

import java.math.BigDecimal;

public class CurrencyConverterBean {

	private Long id;
	private String from;
	private String to;
	private BigDecimal rate;
	private BigDecimal quantity;
	private BigDecimal convertedValue;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getConvertedValue() {
		return convertedValue;
	}
	public void setConvertedValue(BigDecimal convertedValue) {
		this.convertedValue = convertedValue;
	}
	public CurrencyConverterBean(Long id, String from, String to, BigDecimal rate, BigDecimal quantity,
			BigDecimal convertedValue) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.rate = rate;
		this.quantity = quantity;
		this.convertedValue = convertedValue;
	}
	public CurrencyConverterBean() {
		super();
	}
	@Override
	public String toString() {
		return "CurrencyConverterBean [id=" + id + ", from=" + from + ", to=" + to + ", rate=" + rate + ", quantity="
				+ quantity + ", convertedValue=" + convertedValue + "]";
	}
	
	public void calculate()
	{
		convertedValue=quantity.multiply(rate);
	}
	
	
}
