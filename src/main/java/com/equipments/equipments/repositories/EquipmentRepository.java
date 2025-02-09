package com.equipments.equipments.repositories;

import com.equipments.equipments.models.EquipmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentModel, UUID> {

}
