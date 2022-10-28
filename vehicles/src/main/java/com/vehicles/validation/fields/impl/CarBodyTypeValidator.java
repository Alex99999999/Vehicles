package com.vehicles.validation.fields.impl;

import com.vehicles.constants.CarBodyType;
import com.vehicles.dto.request.VehicleStringInputDto;
import com.vehicles.validation.fields.FieldsValidator;

import java.util.Arrays;

public class CarBodyTypeValidator extends FieldsValidator {

    @Override
    public boolean doValidate(VehicleStringInputDto vehicleDto) {
        return Arrays.stream(CarBodyType.values())
                .anyMatch(e -> e.name().equalsIgnoreCase(vehicleDto.getBodyType()));
    }

}
