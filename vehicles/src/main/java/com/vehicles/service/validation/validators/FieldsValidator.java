package com.vehicles.service.validation.validators;

import java.util.List;
import java.util.Map;

public abstract class FieldsValidator {

    protected static final String VEHICLE_TYPE = "type";
    protected static final String VEHICLE_COLOR = "color";
    protected static final String FABRICATION_DATE = "fabricationDate";
    protected static final String CAR_BODY_TYPE = "bodyType";
    protected static final String TRUCK_LOADING_CAPACITY = "loadingCapacity";
    private FieldsValidator nextValidator;

    public abstract boolean doValidate(Map<String, String> fieldValues);

    public void link(FieldsValidator first, List<FieldsValidator> validators) {
        FieldsValidator head = first;
        for (FieldsValidator validator : validators) {
            head.nextValidator = validator;
            head = validator;
        }
    }

    protected boolean isValid(Map<String, String> fieldValues) {
        if (nextValidator == null) {
            return true;
        }
        return nextValidator.doValidate(fieldValues);
    }

}
