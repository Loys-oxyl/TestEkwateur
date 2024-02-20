package com.test.ekwateur.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record ConsumptionDto(@NotNull long gasConsumptionInKwh, @NotNull long electricityConsumptionInKwh, @Valid @NotNull ClientDto client) {}
