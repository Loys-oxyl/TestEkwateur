package com.test.ekwateur.service;

import org.springframework.stereotype.Service;

import com.test.ekwateur.model.Bill;
import com.test.ekwateur.model.Consumption;
import com.test.ekwateur.model.ParticularCalculatorProperties;
import com.test.ekwateur.model.Professional;
import com.test.ekwateur.model.ProfessionalCalculatorProperties;

@Service
public class BillingService {
	
	private ParticularCalculatorProperties particularCalculatorProperties;
	private ProfessionalCalculatorProperties professionalCalculatorProperties;
	
	
	public BillingService(ParticularCalculatorProperties particularCalculatorProperties,
			ProfessionalCalculatorProperties professionalCalculatorProperties) {
		this.particularCalculatorProperties = particularCalculatorProperties;
		this.professionalCalculatorProperties = professionalCalculatorProperties;
	}
	
	public Bill calculate(Consumption consumption) {
		
		return switch(consumption.clientType()) {
			case PARTICULAR -> calculateParticular(consumption);
			
			case PROFESSIONAL -> calculateProfessional(consumption);
		};
	}
	
	private Bill calculateParticular(Consumption consumption) {
		double gasConsumptionInEuro = consumption.gasConsumptionInKwh()*particularCalculatorProperties.getGasPrice();
		double electricityConsumptionInEuro = consumption.electricityConsumptionInKwh()*particularCalculatorProperties.getElectricityPrice();
		double totalConsumptionInEuro = gasConsumptionInEuro + electricityConsumptionInEuro;
		return new Bill(consumption.client(),gasConsumptionInEuro, electricityConsumptionInEuro, totalConsumptionInEuro);
	}
	
	private Bill calculateProfessional(Consumption consumption) {
		double gasConsumptionInEuro;
		double electricityConsumptionInEuro;
		double totalConsumptionInEuro;
		
		Professional professional = (Professional) consumption.client();
		
		if (professional.getSalesRevenue() < professionalCalculatorProperties.getSalesStage()) {
			gasConsumptionInEuro = consumption.gasConsumptionInKwh()*professionalCalculatorProperties.getBelowStageGasPrice();
			electricityConsumptionInEuro = consumption.gasConsumptionInKwh()*professionalCalculatorProperties.getBelowStageElectricityPrice();
		} else {
			gasConsumptionInEuro = consumption.gasConsumptionInKwh()*professionalCalculatorProperties.getAboveStageGasPrice();
			electricityConsumptionInEuro = consumption.gasConsumptionInKwh()*professionalCalculatorProperties.getAboveStageElectricityPrice();
		}
		totalConsumptionInEuro = gasConsumptionInEuro + electricityConsumptionInEuro;
		return new Bill(consumption.client(),gasConsumptionInEuro, electricityConsumptionInEuro, totalConsumptionInEuro);
	}
}
