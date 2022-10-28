package com.vehicles.generator.writers.filewriter.gif;

import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.writers.filewriter.FileCreator;
import com.vehicles.generator.writers.filewriter.csv.AbstractCsvFileWriter;
import com.vehicles.generator.writers.filewriter.csv.CsvVehicleTypeHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GifVehiclesFileWriter implements FileCreator {

    public List<String> writeFile(Map<String, List<VehicleDto>> mapOfTypes) {
        return List.of( "C:/Pet/storage/VESSELS.gif",
                "C:/Pet/storage/ROCKETS.gif",
                "C:/Pet/storage/CARS.gif",
                "C:/Pet/storage/TRUCKS.gif");
    }

}
