package com.vehicles.generator.writers.filewriter.csv;

import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.writers.filewriter.FileCreator;

import java.util.*;

public class CsvVehiclesFileWriter implements FileCreator {

    public List<String> writeFile(Map<String, List<VehicleDto>> mapOfTypes) {
        List<String> filePaths = new ArrayList<>();
        for (Map.Entry<String, List<VehicleDto>> map : mapOfTypes.entrySet()) {
            AbstractCsvFileWriter fileWriter = CsvVehicleTypeHandler.getCsvWriter(map.getKey());
            filePaths.add(fileWriter.write(map.getValue()));
        }
        return filePaths;
    }

}
