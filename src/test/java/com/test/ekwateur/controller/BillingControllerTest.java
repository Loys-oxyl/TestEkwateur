package com.test.ekwateur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.ekwateur.controller.dto.BillDto;
import com.test.ekwateur.controller.dto.ClientDto;
import com.test.ekwateur.controller.dto.ConsumptionDto;
import com.test.ekwateur.model.Civility;
import com.test.ekwateur.model.ClientType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.junit.Assert.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class BillingControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private BillingController billingController;
    
    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(billingController).build();
    }
    
    @Test
	void should_return_bad_request_bad_reference() throws Exception {
		ClientDto clientDto = new ClientDto("une reference", ClientType.PARTICULAR, Civility.M, "toto", "titi");
		ConsumptionDto consomptionDto = new ConsumptionDto(2000, 2000, clientDto);
		
		mockMvc.perform(
				post("/facturations")
				.contentType(APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(consomptionDto)))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	void should_return_particular_information() throws Exception {
		ClientDto clientDto = new ClientDto("EKW23456789", ClientType.PARTICULAR, Civility.M, "toto", "titi");
		ConsumptionDto consomptionDto = new ConsumptionDto(2000, 2000, clientDto);
		
		BillDto expected = new BillDto(clientDto, 230.0, 242.0, 472.0);
		
		String result = mockMvc.perform(
				post("/facturations")
				.contentType(APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(consomptionDto)))
		.andExpect(status().isOk())
		.andReturn()
		.getResponse()
		.getContentAsString();
		
		BillDto billResult = objectMapper.readValue(result, BillDto.class);

		assertEquals(billResult, expected);
	}
	
	@Test
	void should_return_professional_information() throws Exception {
		ClientDto clientDto = new ClientDto("EKW23456789", ClientType.PROFESSIONAL, "siret", "reason", 100_000.0);
		ConsumptionDto consomptionDto = new ConsumptionDto(2000, 2000, clientDto);
		
		BillDto expected = new BillDto(clientDto, 226.0, 236.0, 462.0);
		
		String result = mockMvc.perform(
				post("/facturations")
				.contentType(APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(consomptionDto)))
		.andExpect(status().isOk())
		.andReturn()
		.getResponse()
		.getContentAsString();
		
		BillDto billResult = objectMapper.readValue(result, BillDto.class);

		assertEquals(billResult, expected);
	}
}
