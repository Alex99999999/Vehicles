package com.vehicles.generator.writers.filewriter.json;

import com.vehicles.generator.constants.VehicleType;
import com.vehicles.generator.exception.exceptions.NoSuchWriterException;
import com.vehicles.generator.writers.filewriter.json.impl.JsonCarFileWriter;
import com.vehicles.generator.writers.filewriter.json.impl.JsonRocketFileWriter;
import com.vehicles.generator.writers.filewriter.json.impl.JsonTruckFileWriter;
import com.vehicles.generator.writers.filewriter.json.impl.JsonVesselFileWriter;

import java.util.HashMap;
import java.util.Map;

public class JsonVehicleTypeHandler {

    private static final Map<String, AbstractJsonFileWriter> map;

    static {
        map = new HashMap<>();
        map.put(VehicleType.CAR.name(), new JsonCarFileWriter());
        map.put(VehicleType.TRUCK.name(), new JsonTruckFileWriter());
        map.put(VehicleType.VESSEL.name(), new JsonVesselFileWriter());
        map.put(VehicleType.ROCKET.name(), new JsonRocketFileWriter());
    }

    public static AbstractJsonFileWriter getJsonWriter(String vehicleType) {
        AbstractJsonFileWriter writer = map.get(vehicleType);
        if (writer == null) {
            throw new NoSuchWriterException(String.format("No JSON writer for vehicle type vehicleType %S", vehicleType));
        }
        return writer;
    }

}
