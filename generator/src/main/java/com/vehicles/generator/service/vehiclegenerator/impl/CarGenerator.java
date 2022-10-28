package com.vehicles.generator.service.vehiclegenerator.impl;

import com.vehicles.generator.constants.CarBodyType;
import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.service.vehiclegenerator.VehicleDtoGenerator;

import java.util.Random;

public class CarGenerator extends VehicleDtoGenerator {

    @Override
    public void setSpecificFields(VehicleDto vehicleDto) {
        vehicleDto.setBodyType(peekBodyType());
        vehicleDto.setLoadingCapacity(null);
    }

    private String peekBodyType() {
        int randomIndex = new Random().nextInt(0, CarBodyType.values().length);
        return CarBodyType.values()[randomIndex].name();
    }

}
