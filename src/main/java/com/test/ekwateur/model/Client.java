package com.test.ekwateur.model;

import jakarta.validation.constraints.Pattern;

public abstract class Client {
	
	@Pattern(regexp = "^EKW(\\d){8}$")
	private final String reference;
	
	public Client(String reference) {
		this.reference = reference;
	}

	public String getReference() {
		return reference;
	}
	
}
