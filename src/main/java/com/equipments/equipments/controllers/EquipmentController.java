package com.equipments.equipments.controllers;

import com.equipments.equipments.dtos.EquipmentDto;
import com.equipments.equipments.models.EquipmentModel;
import com.equipments.equipments.models.EquipmentTypeModel;
import com.equipments.equipments.repositories.EquipmentRepository;
import com.equipments.equipments.repositories.EquipmentTypeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("equipments")
@RestController
public class EquipmentController {

    @Autowired
    EquipmentRepository equipmentRepository;

    @Autowired
    EquipmentTypeRepository equipmentTypeRepository;

    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody @Valid EquipmentDto equipmentDto) {
        Optional<EquipmentTypeModel> typeOptional = equipmentTypeRepository.findById(equipmentDto.equipmentTypeId());


        if (typeOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo não encontrado");
        }

        var equipmentModel = new EquipmentModel();
        BeanUtils.copyProperties(equipmentDto, equipmentModel);
        equipmentModel.setEquipmentTypeModel(typeOptional.get());


        return ResponseEntity.status(HttpStatus.CREATED).body(equipmentRepository.save(equipmentModel));
    }

    @GetMapping
    public ResponseEntity<List<EquipmentModel>> getEquipments(){
        return ResponseEntity.status(HttpStatus.OK).body(equipmentRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getEquipment(@RequestBody @PathVariable(value = "id") UUID id){
        Optional<EquipmentModel> equipment = equipmentRepository.findById(id);

        if(equipment.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipamento não foi encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(equipment.get());
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEquipment(@PathVariable(value = "id") UUID id) {
        Optional<EquipmentModel> equipment = equipmentRepository.findById(id);
        if(equipment.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipamento não encontrado");
        }
        equipmentRepository.delete(equipment.get());
        return ResponseEntity.status(HttpStatus.OK).body("Equipamento removido com sucesso");

    }

}
