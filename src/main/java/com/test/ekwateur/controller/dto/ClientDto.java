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
	private Double salesRevenue;
	
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
			String siretNumber, String socialReason, Double salesRevenue) {
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
			String siretNumber, String socialReason, Double salesRevenue) {
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

	public Double getSalesRevenue() {
		return salesRevenue;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		
		if (o == null || getClass() != o.getClass()) 
			return false;
		
		ClientDto clientDto = (ClientDto)o;
		
		return reference.equals(clientDto.reference)
				&& clientType.equals(clientDto.clientType)
				&& (civility == clientDto.civility || civility.equals(clientDto.civility))
				&& (lastName == clientDto.lastName || lastName.equals(clientDto.lastName))
				&& (firstName == clientDto.firstName || firstName.equals(clientDto.firstName))
				&& (civility == clientDto.civility || siretNumber.equals(clientDto.siretNumber))
				&& (socialReason == clientDto.socialReason || socialReason.equals(clientDto.socialReason))
				&& (civility == clientDto.civility || salesRevenue.equals(clientDto.salesRevenue));

	}
}
