package com.vehicles.service.validation.validators.impl;

import com.vehicles.domain.constants.CarBodyType;
import com.vehicles.service.validation.validators.FieldsValidator;

import java.util.Arrays;
import java.util.Map;

public class CarBodyTypeValidator extends FieldsValidator {

    @Override
    public boolean doValidate(Map<String, String> fieldValues) {
        boolean isValid = Arrays.stream(CarBodyType.values())
                .anyMatch(e -> e.name().equalsIgnoreCase(fieldValues.get(CAR_BODY_TYPE)));
        if (!isValid) {
            return false;
        }
        return isValid(fieldValues);
    }

}
