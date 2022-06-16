package com.xoriant.ecart.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.ecart.dao.CurrencyExchangeDao;
import com.xoriant.ecart.dto.CurrecnyConversionModel;
import com.xoriant.ecart.dto.CurrencyConversion;
import com.xoriant.ecart.model.CurrencyExchange;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

	private static final Logger logger = Logger.getLogger(CurrencyExchangeServiceImpl.class.getName());
	@Autowired
	private CurrencyExchangeDao currencyExchangeDao;

	@Autowired
	CurrencyExchangeProxy currencyExchangeProxy;

	@Override
	public CurrencyExchange getCurrencyExchange(CurrencyExchange currencyExchange) {
		logger.info("getCurrencyExchange() called");
		return currencyExchangeDao.save(currencyExchange);
	}

	@Override
	public String addNewCurrencyConversionDetails(CurrecnyConversionModel currecnyConversionModel) {
		logger.info("addNewCurrencyConversionDetails() called");
		return currencyExchangeProxy.addNewCurrencyConversionDetails(currecnyConversionModel);
	}

	@Override
	public List<CurrencyConversion> fetchAll() {
		logger.info("fetchAll() called");
		return currencyExchangeProxy.fetchAll();
	}

	@Override
	public Optional<CurrencyConversion> fetchById(int id) {
		logger.info("fetchById() called");
		return currencyExchangeProxy.fetchById(id);
	}

	@Override
	public Optional<CurrencyConversion> fetchByFromAndTo(String from, String to) {
		logger.info("fetchByFromAndTo() called");
		return currencyExchangeProxy.fetchByFromAndTo(from, to);
	}

}
