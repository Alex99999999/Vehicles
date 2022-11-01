package com.vehicles.service.validation.chain;

import com.vehicles.service.validation.validators.FieldsValidator;
import com.vehicles.service.validation.validators.impl.TruckLoadingCapacityValidator;

import java.util.List;

public class TruckValidationChain extends VehicleValidationChain {

    @Override
    protected void linkSpecificValidators(FieldsValidator validator) {
        validator.link(validator, List.of (new TruckLoadingCapacityValidator()));
    }

}
