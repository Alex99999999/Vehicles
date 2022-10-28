package com.vehicles.validation.fields;

import com.vehicles.dto.request.VehicleStringInputDto;

public abstract class FieldsValidator {
    private FieldsValidator nextValidator;

    protected abstract boolean doValidate(VehicleStringInputDto vehicleDto);

    public void setNextValidator(FieldsValidator validator) {
        this.nextValidator = nextValidator;
    }

    public boolean isValid(VehicleStringInputDto vehicleDto) {
        if (nextValidator == null) {
            return doValidate(vehicleDto);
        }
        return nextValidator.doValidate(vehicleDto);
    }


}
