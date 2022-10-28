package com.vehicles.generator.writers.filewriter.json;

import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.writers.filewriter.FileCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonVehiclesFileWriter implements FileCreator {

    @Override
    public List<String> writeFile(Map<String, List<VehicleDto>> mapOfTypes) {
        List<String> paths = new ArrayList<>();
        for (Map.Entry<String, List<VehicleDto>> entry : mapOfTypes.entrySet()) {
            AbstractJsonFileWriter fileWriter = JsonVehicleTypeHandler.getJsonWriter(entry.getKey());
            paths.add(fileWriter.write(entry.getValue()));
        }
        return paths;
    }

}
