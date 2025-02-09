package com.equipments.equipments.controllers;


import com.equipments.equipments.dtos.EquipmentStateDto;
import com.equipments.equipments.models.EquipmentStateModel;
import com.equipments.equipments.repositories.EquipmentStateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("equipment_state")
@RestController
public class EquipmentStateController {

    @Autowired
    EquipmentStateRepository equipmentStateRepository;

    @PostMapping
    public ResponseEntity<EquipmentStateModel> createEquipmentState(@RequestBody @Valid EquipmentStateDto equipmentStateDto) {
        var equipmentStateModel = new EquipmentStateModel();
        BeanUtils.copyProperties(equipmentStateDto, equipmentStateModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(equipmentStateRepository.save(equipmentStateModel));
    }

    @GetMapping
    public ResponseEntity<List<EquipmentStateModel>> getEquipmentStates(){
        return ResponseEntity.status(HttpStatus.OK).body(equipmentStateRepository.findAll());
    }

}
