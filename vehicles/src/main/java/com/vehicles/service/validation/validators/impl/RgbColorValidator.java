package com.vehicles.service.validation.validators.impl;

import com.vehicles.service.validation.validators.FieldsValidator;

import java.util.Map;

import static com.vehicles.service.validation.ValidationUtils.RGB_COLOR_REGEX;

public class RgbColorValidator extends FieldsValidator {

    @Override
    public boolean doValidate(Map<String, String> fieldValues) {
        String color = fieldValues.get(VEHICLE_COLOR);
        if (!color.matches(RGB_COLOR_REGEX)) {
            return false;
        }
        return isValid(fieldValues);
    }

}
