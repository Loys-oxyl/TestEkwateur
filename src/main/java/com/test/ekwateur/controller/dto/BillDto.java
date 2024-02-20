package com.test.ekwateur.controller.dto;

public record BillDto(ClientDto client, Double gasConsumptionInEuro, Double electricityConsumptionInEuro, Double totalConsumptionInEuro) {}
