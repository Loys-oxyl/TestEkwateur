package com.test.ekwateur.controller.dto;

import jakarta.validation.constraints.NotNull;

public record ConsumptionDto(@NotNull long gasConsumptionInKwh, @NotNull long electricityConsumptionInKwh, @NotNull ClientDto client) {}
