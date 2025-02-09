package com.equipments.equipments.controllers;


import com.equipments.equipments.dtos.EquipmentTypeDto;
import com.equipments.equipments.models.EquipmentTypeModel;
import com.equipments.equipments.repositories.EquipmentTypeRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/equipment-type")
public class EquipmentTypeController {

    @Autowired
    EquipmentTypeRepository equipmentTypeRepository;

    @PostMapping
    public ResponseEntity<EquipmentTypeModel> createEquipmentType(@RequestBody @Valid EquipmentTypeDto equipmentTypeDto){

        var equipmentTypeModel = new EquipmentTypeModel();

        BeanUtils.copyProperties(equipmentTypeDto, equipmentTypeModel);

        return ResponseEntity.ok().body(equipmentTypeRepository.save(equipmentTypeModel));
    }

    @GetMapping
    public ResponseEntity<List<EquipmentTypeModel>> getAllEquipmentType(){

        return ResponseEntity.ok().body(equipmentTypeRepository.findAll());

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteEquipmentType(@PathVariable(value = "id")UUID id){
        Optional<EquipmentTypeModel> type = equipmentTypeRepository.findById(id);

        if(type.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
        }
        equipmentTypeRepository.delete(type.get());
        return ResponseEntity.status(HttpStatus.OK).body("Tipo do equipamento removido com sucesso!");
    }


}
