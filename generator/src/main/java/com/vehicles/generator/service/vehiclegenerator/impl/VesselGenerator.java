package com.vehicles.generator.service.vehiclegenerator.impl;

import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.service.vehiclegenerator.VehicleDtoGenerator;

public class VesselGenerator extends VehicleDtoGenerator {

    @Override
    public void setSpecificFields(VehicleDto vehicleDto) {
        vehicleDto.setBodyType(null);
        vehicleDto.setLoadingCapacity(null);
    }

}
