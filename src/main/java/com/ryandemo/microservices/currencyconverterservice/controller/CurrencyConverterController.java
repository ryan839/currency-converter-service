package com.ryandemo.microservices.currencyconverterservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ryandemo.microservices.currencyconverterservice.bean.CurrencyConverterBean;

@RefreshScope
@RestController
public class CurrencyConverterController {

	@Value("${link:NOT WORKING}")
	private String link;
	
	
	@GetMapping("convert-currency/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverterBean converyCurrency(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable  BigDecimal quantity
			)
	{
		Map<String,String> uriVariable=new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		
		
		
		
		ResponseEntity<CurrencyConverterBean> responseEntity=
				new RestTemplate().getForEntity(
						link,
				CurrencyConverterBean.class, uriVariable);
		
		CurrencyConverterBean response=responseEntity.getBody();
		response.setQuantity(quantity);
		response.calculate();
		
		return response;
	}

}
