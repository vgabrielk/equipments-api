package com.equipments.equipments.dtos;


import jakarta.validation.constraints.NotBlank;

public record EquipmentTypeDto(@NotBlank String name) {
}
