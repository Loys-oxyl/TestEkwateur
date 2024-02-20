package com.test.ekwateur.controller;

import org.springframework.stereotype.Component;

import com.test.ekwateur.controller.dto.ConsumptionDto;
import com.test.ekwateur.model.Consumption;

@Component
public class ConsumptionMapper {
	
	private ClientMapper clientMapper;
	
	public ConsumptionMapper(ClientMapper clientMapper) {
		this.clientMapper = clientMapper;
	}
	
	public Consumption toModel(ConsumptionDto consumptionDto) {
		return new Consumption(consumptionDto.gasConsumptionInKwh(), consumptionDto.electricityConsumptionInKwh(),
				clientMapper.fromDto(consumptionDto.client()), consumptionDto.client().getClientType());
	}
}
