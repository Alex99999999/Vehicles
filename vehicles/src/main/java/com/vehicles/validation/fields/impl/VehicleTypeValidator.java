package com.vehicles.validation.fields.impl;

import com.vehicles.constants.VehicleType;
import com.vehicles.dto.request.VehicleStringInputDto;
import com.vehicles.validation.fields.FieldsValidator;

import java.util.Arrays;

public class VehicleTypeValidator extends FieldsValidator {

    @Override
    public boolean doValidate(VehicleStringInputDto vehicleDto) {
        return Arrays.stream(VehicleType.values())
                .anyMatch(e -> e.name().equalsIgnoreCase(vehicleDto.getType()));
    }

}
