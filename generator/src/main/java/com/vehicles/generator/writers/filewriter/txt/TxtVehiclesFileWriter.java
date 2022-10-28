package com.vehicles.generator.writers.filewriter.txt;

import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.writers.filewriter.FileCreator;

import java.util.List;
import java.util.Map;

public class TxtVehiclesFileWriter implements FileCreator {

    public List<String> writeFile(Map<String, List<VehicleDto>> mapOfTypes) {
        return List.of( "C:/Pet/storage/VESSELS.txt",
                "C:/Pet/storage/ROCKETS.txt",
                "C:/Pet/storage/CARS.txt",
                "C:/Pet/storage/TRUCKS.txt");
    }

}
