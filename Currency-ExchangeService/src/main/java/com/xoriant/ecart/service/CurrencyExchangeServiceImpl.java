package com.xoriant.ecart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.ecart.dao.CurrencyExchangeDao;
import com.xoriant.ecart.dto.CurrecnyConversionModel;
import com.xoriant.ecart.dto.CurrencyConversion;
import com.xoriant.ecart.model.CurrencyExchange;


@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeDao currencyExchangeDao;

	@Autowired
	CurrencyExchangeProxy currencyExchangeProxy;
	
	@Override
	public CurrencyExchange getCurrencyExchange(CurrencyExchange currencyExchange) {
		return currencyExchangeDao.save(currencyExchange);
	}

	@Override
	public String addNewCurrencyConversionDetails(CurrecnyConversionModel currecnyConversionModel) {
		return currencyExchangeProxy.addNewCurrencyConversionDetails(currecnyConversionModel);
	}

	@Override
	public List<CurrencyConversion> fetchAll() {
		return currencyExchangeProxy.fetchAll();
	}

	@Override
	public Optional<CurrencyConversion> fetchById(int id) {
		return currencyExchangeProxy.fetchById(id);
	}

	@Override
	public Optional<CurrencyConversion> fetchByFromAndTo(String from, String to) {
		return currencyExchangeProxy.fetchByFromAndTo(from, to);
	}

}
