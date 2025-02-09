package com.equipments.equipments.models;

import jakarta.persistence.*;

import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "equipments")
public class EquipmentModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique=true)
    private String name;


    public EquipmentTypeModel getEquipmentTypeModel() {
        return equipmentTypeModel;
    }

    public void setEquipmentTypeModel(EquipmentTypeModel equipmentTypeModel) {
        this.equipmentTypeModel = equipmentTypeModel;
    }

    @ManyToOne
    @JoinColumn(name = "equipment_type_id")
    private EquipmentTypeModel equipmentTypeModel;



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
