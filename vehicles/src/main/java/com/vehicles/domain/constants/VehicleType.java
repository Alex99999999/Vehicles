package com.vehicles.domain.constants;

import com.vehicles.service.builder.AbstractVehicleBuilder;
import com.vehicles.service.builder.CarBuilder;
import com.vehicles.service.builder.TruckBuilder;
import com.vehicles.service.validation.chain.CarValidationChain;
import com.vehicles.service.validation.chain.TruckValidationChain;
import com.vehicles.service.validation.chain.VehicleValidationChain;

public enum VehicleType {

    CAR(new CarValidationChain(), new CarBuilder()),
    TRUCK(new TruckValidationChain(), new TruckBuilder());

    private final VehicleValidationChain validator;
    private final AbstractVehicleBuilder vehicleBuilder;

    VehicleType(VehicleValidationChain validator, AbstractVehicleBuilder vehicleBuilder) {
        this.validator = validator;
        this.vehicleBuilder = vehicleBuilder;
    }

    public VehicleValidationChain getValidator() {
        return validator;
    }

    public AbstractVehicleBuilder getVehicleBuilder() {
        return vehicleBuilder;
    }
}
