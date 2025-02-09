package com.equipments.equipments.dtos;


import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.Repeatable;
import java.util.UUID;
                                                                //Mudar para @NotBlank
public record EquipmentDto(@NotBlank  String name, @Nullable UUID equipmentTypeId) {
}
