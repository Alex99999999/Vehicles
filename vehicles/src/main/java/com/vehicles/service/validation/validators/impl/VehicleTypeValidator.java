package com.vehicles.service.validation.validators.impl;

import com.vehicles.domain.constants.VehicleType;
import com.vehicles.service.validation.validators.FieldsValidator;

import java.util.Arrays;
import java.util.Map;

import static com.vehicles.domain.constants.Fields.VEHICLE_TYPE;

public class VehicleTypeValidator extends FieldsValidator {

    @Override
    public boolean doValidate(Map<String, String> fieldValues) {
        String type = fieldValues.get(VEHICLE_TYPE);
        boolean isValid = Arrays.stream(VehicleType.values())
                .anyMatch(e -> e.name().equalsIgnoreCase(type));
        if (!isValid) {
            return false;
        }
        return isValid(fieldValues);
    }

}
