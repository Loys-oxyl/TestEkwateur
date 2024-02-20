package com.test.ekwateur.controller;

import org.springframework.stereotype.Component;

import com.test.ekwateur.controller.dto.ClientDto;
import com.test.ekwateur.model.Client;
import com.test.ekwateur.model.ClientType;
import com.test.ekwateur.model.Particular;
import com.test.ekwateur.model.Professional;

@Component
public class ClientMapper {

	public Client fromDto(ClientDto clientDto) {
		
		return switch(clientDto.getClientType()) {
		case PARTICULAR -> new Particular(
				clientDto.getReference(),
				clientDto.getCivility(),
				clientDto.getLastName(),
				clientDto.getFirstName()
				);
		case PROFESSIONAL -> new Professional(
				clientDto.getReference(),
				clientDto.getSiretNumber(),
				clientDto.getSocialReason(),
				clientDto.getSalesRevenue()
				);
		};	
	}
}
