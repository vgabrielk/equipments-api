package com.equipments.equipments.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "equipment_state")
public class EquipmentStateModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String name;
    private String color;
}
