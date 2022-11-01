package com.vehicles.service.validation.validators.impl;

import com.vehicles.service.validation.ValidationUtils;
import com.vehicles.service.validation.validators.FieldsValidator;

import java.util.Map;

public class DateValidator extends FieldsValidator {

    @Override
    public boolean doValidate(Map<String, String> fieldValues) {
        boolean isValid = ValidationUtils.validateDate(fieldValues.get(FABRICATION_DATE));
        if (!isValid) {
            return false;
        }
        return isValid(fieldValues);
    }

}
