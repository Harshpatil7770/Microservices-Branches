package com.xoriant.ecart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.xoriant.ecart.dto.CurrecnyConversionModel;
import com.xoriant.ecart.dto.CurrencyConversion;

@FeignClient(name = "currency-conversion", url = "http://localhost:9090/api/currency-conversion")
public interface CurrencyExchangeProxy {

	@PostMapping("/save")
	public String addNewCurrencyConversionDetails(@RequestBody CurrecnyConversionModel currecnyConversionModel);

	@GetMapping("/fetchAll")
	public List<CurrencyConversion> fetchAll();

	@GetMapping("/find/{id}")
	public Optional<CurrencyConversion> fetchById(@PathVariable int id);

	@GetMapping("/find/currency-conversion/{from}/{to}")
	public Optional<CurrencyConversion> fetchByFromAndTo(@PathVariable String from, @PathVariable String to);
}
