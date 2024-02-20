package com.test.ekwateur.model;

public record Bill(Client client, Double gasConsumptionInEuro, Double electricityConsumptionInEuro, Double totalConsumptionInEuro) {

}
