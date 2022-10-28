package com.vehicles.validation.vehicle;

import com.vehicles.validation.fields.FieldsValidator;
import com.vehicles.validation.fields.impl.DateValidator;
import com.vehicles.validation.fields.impl.RgbColorValidator;
import com.vehicles.validation.fields.impl.VehicleTypeValidator;

public abstract class VehicleValidator {

    protected FieldsValidator fieldsValidator;

    protected VehicleValidator() {
        fieldsValidator = new VehicleTypeValidator();
        fieldsValidator.setNextValidator(new RgbColorValidator());
        fieldsValidator.setNextValidator(new DateValidator());
    }

    protected abstract void setSpecificValidators();

    public FieldsValidator getValidator() {
        return this.fieldsValidator;
    }

}
