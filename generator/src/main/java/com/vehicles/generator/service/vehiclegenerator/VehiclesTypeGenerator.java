package com.vehicles.generator.service.vehiclegenerator;

import com.vehicles.generator.constants.VehicleType;
import com.vehicles.generator.service.vehiclegenerator.impl.CarGenerator;
import com.vehicles.generator.service.vehiclegenerator.impl.RocketGenerator;
import com.vehicles.generator.service.vehiclegenerator.impl.TruckGenerator;
import com.vehicles.generator.service.vehiclegenerator.impl.VesselGenerator;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class VehiclesTypeGenerator {

    private final Map<String, VehicleDtoGenerator> vehiclesGenerators;

    {
        vehiclesGenerators = new HashMap<>();
        vehiclesGenerators.put(VehicleType.CAR.name(), new CarGenerator());
        vehiclesGenerators.put(VehicleType.TRUCK.name(), new TruckGenerator());
        vehiclesGenerators.put(VehicleType.VESSEL.name(), new VesselGenerator());
        vehiclesGenerators.put(VehicleType.ROCKET.name(), new RocketGenerator());
    }

}
