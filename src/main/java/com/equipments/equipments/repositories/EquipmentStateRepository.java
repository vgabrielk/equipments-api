package com.equipments.equipments.repositories;

import com.equipments.equipments.models.EquipmentStateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EquipmentStateRepository extends JpaRepository<EquipmentStateModel, UUID> {
}
