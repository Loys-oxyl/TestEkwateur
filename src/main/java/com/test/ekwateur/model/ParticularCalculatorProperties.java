package com.test.ekwateur.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;

@Validated
@ConfigurationProperties(prefix = "particular")
@ConfigurationPropertiesScan
public class ParticularCalculatorProperties {

	@NotNull
    private final Double electricityPrice;

    @NotNull
    private final Double gasPrice;
	
	public ParticularCalculatorProperties(Double electricityPrice, Double gasPrice) {
		this.electricityPrice = electricityPrice;
		this.gasPrice = gasPrice;
	}

	public Double getGasPrice() {
		return gasPrice;
	}
	
	public Double getElectricityPrice() {
		return electricityPrice;
	}
}
