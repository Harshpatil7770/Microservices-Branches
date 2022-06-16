package com.xoriant.ecart.controller;

import java.math.BigDecimal;
import java.util.Optional;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.dao.CurrencyExchangeDao;
import com.xoriant.ecart.dto.CurrencyConversion;
import com.xoriant.ecart.model.CurrencyExchange;
import com.xoriant.ecart.service.CurrencyExchangeService;

@RequestMapping("/api/currency-exchange")
@RestController
public class CurrencyExchangeController {

	private static final Logger logger = Logger.getLogger(CurrencyExchangeController.class.getName());

	@Autowired(required = false)
	private CurrencyExchangeService currencyExchangeService;

	@Autowired(required = false)
	CurrencyConversion currencyConversion;

	@Autowired
	private CurrencyExchangeDao currencyExchangeDao;

	@Autowired
	JmsTemplate jmsTemplate;

	@GetMapping("/{id}/quantity/{quantity}")
	public CurrencyExchange getCurrencyExchange(@PathVariable int id, @PathVariable BigDecimal quantity) {
		Optional<CurrencyConversion> currencyExchange = currencyExchangeService.fetchById(id);
		CurrencyExchange exchange = new CurrencyExchange(id, currencyExchange.get().getFrom(),
				currencyExchange.get().getTo(), currencyExchange.get().getConversionForm(), quantity,
				quantity.multiply(currencyExchange.get().getConversionForm()));

		jmsTemplate.send("currency-exchangeQ", new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				return session
						.createObjectMessage("Totol " + quantity.multiply(currencyExchange.get().getConversionForm())
								+ "Amount Need To Pay For the conversion Of Money From"
								+ currencyExchange.get().getFrom() + " To " + currencyExchange.get().getTo());
			}
		});

		currencyExchangeDao.save(exchange);

		logger.info("getCurrencyExchange() called");
		return exchange;

	}
}
