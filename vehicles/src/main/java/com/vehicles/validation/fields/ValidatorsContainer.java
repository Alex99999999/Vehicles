package com.vehicles.validation.fields;

import com.vehicles.constants.VehicleType;
import com.vehicles.validation.vehicle.CarValidator;
import com.vehicles.validation.vehicle.TruckValidator;
import com.vehicles.validation.vehicle.VehicleValidator;

import java.util.HashMap;
import java.util.Map;

public class ValidatorsContainer {

    private static final Map<String, VehicleValidator> map;

    static {
        map = new HashMap<>();
        map.put(VehicleType.CAR.name(), new CarValidator());
        map.put(VehicleType.TRUCK.name(), new TruckValidator());
    }

    public static VehicleValidator getValidator(String vehicleType) {
        return map.get(vehicleType);
    }

}
