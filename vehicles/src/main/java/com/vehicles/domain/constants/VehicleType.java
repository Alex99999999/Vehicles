package com.vehicles.domain.constants;

import com.vehicles.service.validation.chain.CarValidationChain;
import com.vehicles.service.validation.chain.TruckValidationChain;
import com.vehicles.service.validation.chain.VehicleValidationChain;

public enum VehicleType {

    CAR(new CarValidationChain()),
    TRUCK(new TruckValidationChain());

    private final VehicleValidationChain validator;

    VehicleType(VehicleValidationChain validator) {
        this.validator = validator;
    }

    public VehicleValidationChain getValidator() {
        return validator;
    }
}
