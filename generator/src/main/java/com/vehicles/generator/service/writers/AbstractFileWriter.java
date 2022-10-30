package com.vehicles.generator.service.writers;

import com.vehicles.generator.controller.dto.VehicleDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public abstract class AbstractFileWriter {

    protected String defaultFilePath = "C:/Pet/storage/";
    public List<String> writeAllIntoAppropriateFiles(Map<String, List<VehicleDto>> mapOfTypes) {
        List<String> filePaths = new ArrayList<>();
        for (Map.Entry<String, List<VehicleDto>> map : mapOfTypes.entrySet()) {
            filePaths.add(writeToFile(map.getKey(), map.getValue()));
        }
        return filePaths;
    }

    protected abstract String writeToFile(String type, List<VehicleDto> value);

}
