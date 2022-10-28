package com.vehicles.validation.fields.impl;

import com.vehicles.dto.request.VehicleStringInputDto;
import com.vehicles.validation.fields.FieldsValidator;

import static com.vehicles.validation.ValidationUtils.RGB_COLOR_REGEX;

public class RgbColorValidator extends FieldsValidator {

    @Override
    public boolean doValidate(VehicleStringInputDto vehicleDto) {
        return vehicleDto.getColor().matches(RGB_COLOR_REGEX);
    }

}
