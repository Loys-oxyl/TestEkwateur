package com.test.ekwateur.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;

@Validated
@ConfigurationProperties(prefix = "professional")
@ConfigurationPropertiesScan
public class ProfessionalCalculatorProperties {

	@NotNull
    private final Long salesStage;

    @NotNull
    private final Double aboveStageElectricityPrice;

    @NotNull
    private final Double aboveStageGasPrice;

    @NotNull
    private final Double belowStageElectricityPrice;

    @NotNull
    private final Double belowStageGasPrice;
    
	public ProfessionalCalculatorProperties(Long salesStage,
    		Double aboveStageElectricityPrice, Double aboveStageGasPrice,
    		Double belowStageElectricityPrice, Double belowStageGasPrice) {
    	this.salesStage = salesStage;
    	this.aboveStageElectricityPrice = aboveStageElectricityPrice;
    	this.aboveStageGasPrice = aboveStageGasPrice;
    	this.belowStageElectricityPrice = belowStageElectricityPrice;
    	this.belowStageGasPrice = belowStageGasPrice;
    }
	
	public Long getSalesStage() {
		return salesStage;
	}
	
    public Double getAboveStageElectricityPrice() {
		return aboveStageElectricityPrice;
	}
    
    public Double getAboveStageGasPrice() {
		return aboveStageGasPrice;
	}
    
    public Double getBelowStageElectricityPrice() {
		return belowStageElectricityPrice;
	}
    
    public Double getBelowStageGasPrice() {
		return belowStageGasPrice;
	}
}
