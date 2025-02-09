package com.equipments.equipments.repositories;

import com.equipments.equipments.models.EquipmentTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EquipmentTypeRepository extends JpaRepository<EquipmentTypeModel, UUID> {
}
