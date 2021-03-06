package com.xoriant.ecart.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "currency_exchange")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchange {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "currency_from")
	private String from;

	@Column(name = "currency_to")
	private String to;

	@Column(name = "conversion_multiple")
	private BigDecimal conversionMultiple;

	@Column(name = "quantity")
	private BigDecimal quantity;

	@Column(name = "total_amount")
	private BigDecimal totalAmount;

}
