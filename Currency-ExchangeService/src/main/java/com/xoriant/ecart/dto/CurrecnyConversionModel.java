package com.xoriant.ecart.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrecnyConversionModel {

	private String from;

	private String to;

	private BigDecimal conversionForm;
}
