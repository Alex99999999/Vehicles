package com.vehicles.generator.service.generator;

import com.vehicles.generator.exception.exceptions.GeneratorException;
import com.vehicles.generator.service.generator.impl.CarGeneratorService;
import com.vehicles.generator.service.generator.impl.RocketGeneratorService;
import com.vehicles.generator.service.generator.impl.TruckGeneratorService;
import com.vehicles.generator.service.generator.impl.VesselGeneratorService;

import java.util.HashMap;
import java.util.Map;

public class VehicleGeneratorsHandler {

    private static final Map<String, AbstractGeneratorService> vehiclesGenerators;

    static {
        vehiclesGenerators = new HashMap<>();
        vehiclesGenerators.put("CAR", new CarGeneratorService());
        vehiclesGenerators.put("TRUCK", new TruckGeneratorService());
        vehiclesGenerators.put("VESSEL", new VesselGeneratorService());
        vehiclesGenerators.put("ROCKET", new RocketGeneratorService());
    }

    public static AbstractGeneratorService getVehicleGenerator(String type) {
        AbstractGeneratorService generator = vehiclesGenerators.get(type);
        if (generator == null) {
            throw new GeneratorException(String.format("No generator for type %s", type));
        }
        return generator;
    }


}
