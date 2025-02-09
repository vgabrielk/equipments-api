package com.equipments.equipments.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public record EquipmentStateDto(@NotBlank String name, @Nullable String color) {
}
