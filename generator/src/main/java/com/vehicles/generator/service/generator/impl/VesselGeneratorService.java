package com.vehicles.generator.service.generator.impl;

import com.vehicles.generator.controller.dto.VehicleDto;
import com.vehicles.generator.controller.dto.VesselDto;
import com.vehicles.generator.service.generator.AbstractGeneratorService;
import org.springframework.stereotype.Service;

@Service
public class VesselGeneratorService extends AbstractGeneratorService {

    @Override
    public VehicleDto generateSpecificFields(VehicleDto dto) {
        return VesselDto.builder()
                .type(dto.getType())
                .color(dto.getColor())
                .fabricationDate(dto.getFabricationDate())
                .capacity(generateCapacity())
                .build();
    }

    private String generateCapacity() {
        return "50000t";
    }

}
