package com.equipments.equipments.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "equipment_type")
public class EquipmentTypeModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

//    @OneToMany(mappedBy = "equipment_type", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<EquipmentModel> equipments = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private String name;
}
