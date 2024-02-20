package com.test.ekwateur.model;

public class Professional extends Client{

	private final String siretNumber;
	private final String socialReason;
	private final Long salesRevenue;
	
	public Professional(String reference, String siretNumber, String socialReason, Long salesRevenue) {
		super(reference);
		this.siretNumber = siretNumber;
		this.socialReason = socialReason;
		this.salesRevenue = salesRevenue;
	}

	public Long getSalesRevenue() {
		return salesRevenue;
	}

	public String getSocialReason() {
		return socialReason;
	}

	public String getSiretNumber() {
		return siretNumber;
	}
}
