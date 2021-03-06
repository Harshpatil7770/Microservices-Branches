package com.xoriant.ecart.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.dto.CurrencyConversion;
import com.xoriant.ecart.model.CurrencyExchange;
import com.xoriant.ecart.service.CurrencyExchangeService;

@RequestMapping("/api/currency-exchange")
@RestController
public class CurrencyExchangeController {

	@Autowired(required=false)
	private CurrencyExchangeService currencyExchangeService;

	@Autowired(required=false)
	CurrencyConversion currencyConversion;

	@GetMapping("/{id}/quantity/{quantity}")
	public CurrencyExchange getCurrencyExchange(@PathVariable int id, @PathVariable BigDecimal quantity) {
		CurrencyExchange currencyExchange = new CurrencyExchange();
		currencyExchange.setFrom(currencyConversion.getFrom());
		currencyExchange.setTo(currencyConversion.getTo());
		currencyExchange.setConversionMultiple(currencyConversion.getConversionForm());
		currencyExchange.setQuantity(quantity);
		currencyExchange.setTotalAmount(quantity.multiply(currencyConversion.getConversionForm()));

		currencyExchangeService.getCurrencyExchange(currencyExchange);
		return currencyExchange;

	}
}
