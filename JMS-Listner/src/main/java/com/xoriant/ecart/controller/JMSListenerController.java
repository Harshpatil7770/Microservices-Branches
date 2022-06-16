package com.xoriant.ecart.controller;

import java.util.logging.Logger;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSListenerController {

	private static final Logger logger = Logger.getLogger(JMSListenerController.class.getName());

	@JmsListener(destination = "currency-conversionQ")
	public void addNewConveryConversionDetails(String message) {
		logger.info("JMS-Listener Called");
		logger.info(message);
	}
}
