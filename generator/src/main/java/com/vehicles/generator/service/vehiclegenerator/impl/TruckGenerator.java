package com.vehicles.generator.service.vehiclegenerator.impl;

import com.vehicles.generator.constants.MassUnit;
import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.service.vehiclegenerator.VehicleDtoGenerator;

import java.util.Random;

public class TruckGenerator extends VehicleDtoGenerator {

    @Override
    public void setSpecificFields(VehicleDto vehicleDto) {
        vehicleDto.setBodyType(null);
        vehicleDto.setLoadingCapacity(peekLoadingCapacity());
    }

    private String peekLoadingCapacity() {
        String weightFormat = "%d%s";
        int randomWeight = new Random().nextInt(0, 40000);
        int randomMassUnitIndex = new Random().nextInt(0, MassUnit.values().length);
        String massUnit = MassUnit.values()[randomMassUnitIndex].name();
        return String.format(weightFormat, randomWeight, massUnit);
    }

}
