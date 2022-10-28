package com.vehicles.generator.service.vehiclegenerator.impl;

import com.vehicles.generator.constants.MassUnit;
import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.service.vehiclegenerator.VehicleDtoGenerator;

import java.util.Random;

public class RocketGenerator extends VehicleDtoGenerator {

    @Override
    public void setSpecificFields(VehicleDto vehicleDto) {
        vehicleDto.setBodyType(null);
        vehicleDto.setLoadingCapacity(null);
    }

}
