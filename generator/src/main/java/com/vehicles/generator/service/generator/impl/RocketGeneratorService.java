package com.vehicles.generator.service.generator.impl;

import com.vehicles.generator.controller.dto.RocketDto;
import com.vehicles.generator.controller.dto.VehicleDto;
import com.vehicles.generator.service.generator.AbstractGeneratorService;
import org.springframework.stereotype.Service;

@Service
public class RocketGeneratorService extends AbstractGeneratorService {


    @Override
    public VehicleDto generateSpecificFields(VehicleDto dto) {
        return RocketDto.builder()
                .type(dto.getType())
                .color(dto.getColor())
                .fabricationDate(dto.getFabricationDate())
                .velocity(generateVelocity())
                .build();
    }

    private String generateVelocity() {
        return "3444 m/s";
    }
}
