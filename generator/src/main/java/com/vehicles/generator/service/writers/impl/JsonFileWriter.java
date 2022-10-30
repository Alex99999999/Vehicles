package com.vehicles.generator.service.writers.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vehicles.generator.controller.dto.VehicleDto;
import com.vehicles.generator.exception.exceptions.GeneratorException;
import com.vehicles.generator.service.writers.AbstractFileWriter;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class JsonFileWriter extends AbstractFileWriter {


    @Override
    protected String writeToFile(String type, List<VehicleDto> dtoList) {
        String fileName = type + ".json";
        String path = this.defaultFilePath + fileName;
        File csvFile = new File(path);
        writeAllToFile(csvFile, dtoList);
        return fileName;
    }

    private void writeAllToFile(File csvFile, List<VehicleDto> dtoList) {
        ObjectMapper objectMapper = new ObjectMapper();
        try (FileWriter writer = new FileWriter(csvFile, true)) {
            for (VehicleDto dto : dtoList) {
                writer.write(objectMapper.writeValueAsString(dto));
            }
        } catch (IOException e) {
            throw new GeneratorException("Error while writing into file occurred");
        }
    }

}
