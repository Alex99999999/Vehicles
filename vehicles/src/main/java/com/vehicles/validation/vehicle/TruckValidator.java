package com.vehicles.validation.vehicle;

import com.vehicles.validation.fields.impl.TruckLoadingCapacityValidator;

public class TruckValidator extends VehicleValidator {

    @Override
    protected void setSpecificValidators() {
        fieldsValidator.setNextValidator(new TruckLoadingCapacityValidator());
    }
}
