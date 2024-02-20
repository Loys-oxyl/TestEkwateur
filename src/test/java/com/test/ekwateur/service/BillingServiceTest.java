package com.test.ekwateur.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.ekwateur.model.Bill;
import com.test.ekwateur.model.Civility;
import com.test.ekwateur.model.ClientType;
import com.test.ekwateur.model.Consumption;
import com.test.ekwateur.model.Particular;
import com.test.ekwateur.model.Professional;

@SpringBootTest
public class BillingServiceTest {

	@Autowired
	private BillingService billingService;
	
	@Test
	void should_return_bill_particular_client() {
		Particular particular = new Particular("reference", Civility.M, "toto", "tata");
		Bill expected = new Bill(particular, 230.0, 242.0, 472.0);
		Consumption consomation = new Consumption(2000, 2000, particular, ClientType.PARTICULAR);
		
		Bill result = billingService.calculate(consomation);
		
		assertEquals(result,expected);
	}
	
	@Test
	void should_return_bill_professional_client_below_stage() {
		Professional professional = new Professional("reference", "", "toto", 100_000.0);
		Bill expected = new Bill(professional, 226.0, 236.0, 462.0);
		Consumption consomation = new Consumption(2000, 2000, professional, ClientType.PROFESSIONAL);
		
		Bill result = billingService.calculate(consomation);
		
		assertEquals(result,expected);
	}
	
	@Test
	void should_return_bill_professional_client_above_stage() {
		Professional professional = new Professional("reference", "", "toto", 1_000_001.0);
		Bill expected = new Bill(professional, 222.0, 228.0, 450.0);
		Consumption consomation = new Consumption(2000, 2000, professional, ClientType.PROFESSIONAL);
		
		Bill result = billingService.calculate(consomation);
		
		assertEquals(result,expected);
	}
}
