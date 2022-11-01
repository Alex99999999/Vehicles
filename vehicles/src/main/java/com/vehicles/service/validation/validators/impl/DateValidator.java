package com.vehicles.service.validation.validators.impl;

import com.vehicles.service.Utils;
import com.vehicles.service.validation.validators.FieldsValidator;

import java.util.Map;

import static com.vehicles.domain.constants.Fields.FABRICATION_DATE;

public class DateValidator extends FieldsValidator {

    @Override
    public boolean doValidate(Map<String, String> fieldValues) {
        boolean isValid = Utils.validateDate(fieldValues.get(FABRICATION_DATE));
        if (!isValid) {
            return false;
        }
        return isValid(fieldValues);
    }

}
