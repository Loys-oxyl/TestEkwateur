package com.test.ekwateur.controller.dto;

import com.test.ekwateur.model.Civility;
import com.test.ekwateur.model.ClientType;

import jakarta.validation.constraints.Pattern;

public class ClientDto {
	
	@Pattern(regexp = "^EKW(\\d){8}$")
	private String reference;
	
	private ClientType clientType;
	
	private Civility civility;
	private String lastName;
	private String firstName;

	private String siretNumber;
	private String socialReason;
	private Long salesRevenue;
	
	public ClientDto() {
		
	}
	
	public ClientDto(String reference, ClientType clientType,
			Civility civility, String lastName, String firstName) {
		this.reference = reference;
		this.clientType = clientType;
		this.civility = civility;
		this.lastName = lastName;
		this.firstName = firstName;
		this.siretNumber = null;
		this.socialReason = null;
		this.salesRevenue = null;
	}
	
	public ClientDto(String reference, ClientType clientType,
			String siretNumber, String socialReason, Long salesRevenue) {
		this.reference = reference;
		this.clientType = clientType;
		this.civility = null;
		this.lastName = null;
		this.firstName = null;
		this.siretNumber = siretNumber;
		this.socialReason = socialReason;
		this.salesRevenue = salesRevenue;
	}

	public ClientDto(String reference, ClientType clientType,
			Civility civility, String lastName, String firstName,
			String siretNumber, String socialReason, Long salesRevenue) {
		this.reference = reference;
		this.clientType = clientType;
		this.civility = civility;
		this.lastName = lastName;
		this.firstName = firstName;
		this.siretNumber = siretNumber;
		this.socialReason = socialReason;
		this.salesRevenue = salesRevenue;
	}

	public String getReference() {
		return reference;
	}
	
	public ClientType getClientType() {
		return clientType;
	}
	
	public Civility getCivility() {
		return civility;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getSiretNumber() {
		return siretNumber;
	}

	public String getSocialReason() {
		return socialReason;
	}

	public Long getSalesRevenue() {
		return salesRevenue;
	}
}
