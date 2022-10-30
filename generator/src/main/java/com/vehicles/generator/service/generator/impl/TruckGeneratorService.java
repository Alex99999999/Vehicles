package com.vehicles.generator.service.generator.impl;

import com.vehicles.generator.controller.dto.TruckDto;
import com.vehicles.generator.service.generator.AbstractGeneratorService;
import com.vehicles.generator.service.constants.MassUnit;
import com.vehicles.generator.controller.dto.VehicleDto;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class TruckGeneratorService extends AbstractGeneratorService {


    @Override
    public VehicleDto generateSpecificFields(VehicleDto dto) {
        return TruckDto.builder()
                .type(dto.getType())
                .color(dto.getColor())
                .fabricationDate(dto.getFabricationDate())
                .loadingCapacity(generateLoadingCapacity())
                .build();
    }

    private String generateLoadingCapacity() {
        String weightFormat = "%d%s";
        int randomWeight = new Random().nextInt(0, 40000);
        int randomMassUnitIndex = new Random().nextInt(0, MassUnit.values().length);
        String massUnit = MassUnit.values()[randomMassUnitIndex].name();
        return String.format(weightFormat, randomWeight, massUnit);
    }

}
