package com.xoriant.ecart.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversion {

	private int id;

	private String from;

	private String to;

	private BigDecimal conversionForm;
}
