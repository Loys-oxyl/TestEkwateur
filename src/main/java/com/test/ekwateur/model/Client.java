package com.test.ekwateur.model;

public abstract class Client {
	
	private final String reference;
	
	public Client(String reference) {
		this.reference = reference;
	}

	public String getReference() {
		return reference;
	}
	
}
