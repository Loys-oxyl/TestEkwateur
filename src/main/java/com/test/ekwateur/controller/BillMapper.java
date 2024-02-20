package com.test.ekwateur.controller;

import org.springframework.stereotype.Component;

import com.test.ekwateur.controller.dto.BillDto;
import com.test.ekwateur.controller.dto.ClientDto;
import com.test.ekwateur.model.Bill;

@Component
public class BillMapper {
	
	public BillDto toDto(Bill bill, ClientDto client) {
		return new BillDto(
				client,
				bill.gasConsumptionInEuro(),
				bill.electricityConsumptionInEuro(),
				bill.totalConsumptionInEuro()
				);
	}

}
