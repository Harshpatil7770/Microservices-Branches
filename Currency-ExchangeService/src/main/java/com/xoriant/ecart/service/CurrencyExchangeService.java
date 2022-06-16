package com.xoriant.ecart.service;

import java.util.List;
import java.util.Optional;

import com.xoriant.ecart.dto.CurrecnyConversionModel;
import com.xoriant.ecart.dto.CurrencyConversion;
import com.xoriant.ecart.model.CurrencyExchange;

public interface CurrencyExchangeService {

	CurrencyExchange getCurrencyExchange(CurrencyExchange currencyExchange);

	 String addNewCurrencyConversionDetails(CurrecnyConversionModel currecnyConversionModel);

	 List<CurrencyConversion> fetchAll();

	 Optional<CurrencyConversion> fetchById(int id);

	 Optional<CurrencyConversion> fetchByFromAndTo(String from, String to);
}
