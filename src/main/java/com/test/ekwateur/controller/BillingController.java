package com.test.ekwateur.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.ekwateur.controller.dto.ConsumptionDto;
import com.test.ekwateur.model.Bill;
import com.test.ekwateur.service.BillingService;
import com.test.ekwateur.controller.dto.BillDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/facturations")
public class BillingController {
	
	BillingService billingService;
	BillMapper billMapper;
	ConsumptionMapper consumptionMapper;
	
	public BillingController(BillingService billingService, BillMapper billMapper, ConsumptionMapper consumptionMapper) {
		this.billingService = billingService;
		this.billMapper = billMapper;
		this.consumptionMapper = consumptionMapper;
	}
	
	@PostMapping
	public ResponseEntity<BillDto> calculateBill(@Valid @RequestBody ConsumptionDto consumption) {
		Bill bill = billingService.calculate(consumptionMapper.toModel(consumption));
		
		return ResponseEntity.ok(billMapper.toDto(bill, consumption.client()));
	}

}
