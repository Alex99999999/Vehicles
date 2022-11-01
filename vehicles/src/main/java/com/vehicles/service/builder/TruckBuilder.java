package com.vehicles.service.builder;

import com.vehicles.domain.Truck;
import com.vehicles.domain.Vehicle;
import com.vehicles.domain.constants.MassUnit;

import static com.vehicles.domain.constants.Fields.TRUCK_LOADING_CAPACITY;

public class TruckBuilder extends AbstractVehicleBuilder {

    private final String DEFAULT_MASS_UNIT = "kg";

    @Override
    protected Vehicle setVehicle() {
        return new Truck();
    }

    @Override
    protected void setSpecificFields() {
        ((Truck) vehicle).setLoadingCapacity(getLoadingCapacity());
    }

    private String getLoadingCapacity() {
        String loadingCapacity = fieldValues.get(TRUCK_LOADING_CAPACITY);
        int mass = Integer.parseInt(loadingCapacity.replaceAll("\\D", ""));
        String massUnit = loadingCapacity.replaceAll("\\d", "");
        double factor = MassUnit.valueOf(massUnit. toUpperCase()).getFactor();
        double convertedMass = mass * factor;
        return "" + convertedMass + DEFAULT_MASS_UNIT;
    }

}
