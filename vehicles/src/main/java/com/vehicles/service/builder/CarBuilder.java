package com.vehicles.service.builder;

import com.vehicles.domain.Car;
import com.vehicles.domain.Vehicle;
import com.vehicles.domain.constants.CarBodyType;

import static com.vehicles.domain.constants.Fields.CAR_BODY_TYPE;

public class CarBuilder extends AbstractVehicleBuilder {
    @Override
    protected Vehicle setVehicle() {
        return new Car();
    }

    @Override
    protected void setSpecificFields() {
        ((Car) vehicle).setBodyType(getBodyType());
    }

    private CarBodyType getBodyType() {
        return CarBodyType.valueOf(fieldValues.get(CAR_BODY_TYPE));
    }
}
