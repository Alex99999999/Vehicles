package com.vehicles.validation.vehicle;

import com.vehicles.validation.fields.impl.CarBodyTypeValidator;

public class CarValidator extends VehicleValidator {

    @Override
    protected void setSpecificValidators() {
        fieldsValidator.setNextValidator(new CarBodyTypeValidator());
    }
}
