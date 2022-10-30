package com.vehicles.generator.service.generator.impl;

import com.vehicles.generator.controller.dto.CarDto;
import com.vehicles.generator.service.generator.AbstractGeneratorService;
import com.vehicles.generator.service.constants.CarBodyType;
import com.vehicles.generator.controller.dto.VehicleDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
@Primary
public class CarGeneratorService extends AbstractGeneratorService {

    @Override
    public VehicleDto generateSpecificFields(VehicleDto dto) {
        return CarDto.builder()
                .type(dto.getType())
                .color(dto.getColor())
                .fabricationDate(dto.getFabricationDate())
                .bodyType(generateBodyType())
                .build();
    }

    private String generateBodyType() {
        int randomIndex = new Random().nextInt(0, CarBodyType.values().length);
        return CarBodyType.values()[randomIndex].name();
    }
}
