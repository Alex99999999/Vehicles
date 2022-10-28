package com.vehicles.generator.writers.filewriter.jpg;

import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.writers.filewriter.FileCreator;

import java.util.List;
import java.util.Map;

public class JpgVehiclesFileWriter implements FileCreator {

    public List<String> writeFile(Map<String, List<VehicleDto>> mapOfTypes) {
        return List.of( "C:/Pet/storage/VESSELS.jpg",
                "C:/Pet/storage/ROCKETS.jpg",
                "C:/Pet/storage/CARS.jpg",
                "C:/Pet/storage/TRUCKS.jpg");
    }

}
