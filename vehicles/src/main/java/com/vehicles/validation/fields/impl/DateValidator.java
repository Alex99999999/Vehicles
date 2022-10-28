package com.vehicles.validation.fields.impl;

import com.vehicles.dto.request.VehicleStringInputDto;
import com.vehicles.validation.ValidationUtils;
import com.vehicles.validation.fields.FieldsValidator;

import java.time.format.DateTimeParseException;

public class DateValidator extends FieldsValidator {

    @Override
    public boolean doValidate(VehicleStringInputDto vehicleDto) {
        String inputDate = vehicleDto.getFabricationDate();
        try {
            ValidationUtils.validateDateOrThrowDateFormatException(inputDate);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

}
