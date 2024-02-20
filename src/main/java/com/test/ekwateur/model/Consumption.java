package com.test.ekwateur.model;

public record Consumption(long gasConsumptionInKwh, long electricityConsumptionInKwh, Client client, ClientType clientType) {}
