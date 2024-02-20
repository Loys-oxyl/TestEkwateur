package com.test.ekwateur.model;

public class Particular extends Client {

	private final Civility civility;
	private final String lastName;
	private final String firstName;
	
	public Particular(String reference, Civility civility, String lastName, String firstName) {
		super(reference);
		this.civility = civility;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Civility getCivility() {
		return civility;
	}

}
