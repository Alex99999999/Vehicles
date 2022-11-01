package com.vehicles.service.builder;

import com.vehicles.domain.Vehicle;
import com.vehicles.domain.constants.VehicleType;
import com.vehicles.service.Utils;

import java.time.LocalDate;
import java.util.Map;

import static com.vehicles.domain.constants.Fields.*;

public abstract class AbstractVehicleBuilder {

    protected Vehicle vehicle;
    protected Map<String, String> fieldValues;

    public Vehicle createVehicle(Map<String, String> fieldValues) {
        this.fieldValues = fieldValues;
        vehicle = setVehicle();
        vehicle.setType(getType());
        vehicle.setColor(fieldValues.get(VEHICLE_COLOR));
        vehicle.setFabricationDate(getDate());
        setSpecificFields();
        return vehicle;
    }

    protected abstract Vehicle setVehicle();
    protected abstract void setSpecificFields();

    private VehicleType getType() {
        return VehicleType.valueOf(fieldValues.get(VEHICLE_TYPE).toUpperCase());
    }

    private LocalDate getDate() {
        return Utils.parseDateOrThrowVehicleServiceException(fieldValues.get(FABRICATION_DATE));
    }


}
