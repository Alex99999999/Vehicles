package com.vehicles.generator.service.writers.impl;

import com.vehicles.generator.controller.dto.VehicleDto;
import com.vehicles.generator.exception.exceptions.GeneratorException;
import com.vehicles.generator.service.writers.AbstractFileWriter;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class CsvFileWriter extends AbstractFileWriter {

    @Override
    protected String writeToFile(String type, List<VehicleDto> dtoList) {
        String fileName = type + ".csv";
        String path = this.defaultFilePath + fileName;
        File csvFile = new File(path);
        if (!csvFile.exists()) {
            writeHeaders(csvFile, dtoList.get(0));
        }
        writeListOfDtoToFile(csvFile, dtoList);
        return fileName;
    }

    private void writeHeaders(File csvFile, VehicleDto vehicleDto) {
        List<Field> fieldList = getFieldsList(vehicleDto);
        String headers = fieldList.stream()
                .map(Field::getName)
                .collect(Collectors.joining(";"));
        writeLine(csvFile, headers);
    }

    private void writeListOfDtoToFile(File csvFile, List<VehicleDto> dtoList) {
        try (FileWriter writer = new FileWriter(csvFile, true)) {
            for (VehicleDto dto : dtoList) {
                writer.write(getFieldsAsCsvString(dto) + "\n");
            }
        } catch (IOException e) {
            throw new GeneratorException("Error while writing into file occurred");
        }

        for (VehicleDto dto : dtoList) {
            writeLine(csvFile, getFieldsAsCsvString(dto));
        }
    }

    private void writeLine(File csvFile, String line) {
        try (FileWriter writer = new FileWriter(csvFile, true)) {
            writer.write(line + "\n");
        } catch (IOException e) {
            throw new GeneratorException("Error while writing into file occurred");
        }
    }

    private static String getFieldsAsCsvString(VehicleDto dto) {
        StringJoiner joiner = new StringJoiner(";");
        List<Field> fieldList = getFieldsList(dto);
        for (Field field : fieldList) {
            try {
                field.setAccessible(true);
                joiner.add(field.get(dto).toString());
                field.setAccessible(false);
            } catch (IllegalAccessException e) {
                throw new GeneratorException("Cannot get value of field");
            }
        }
        return joiner.toString();
    }

    private static List<Field> getFieldsList(VehicleDto dto) {
        List<Field> fieldList = new ArrayList<>();
        Class<?> current = dto.getClass();
        while (current.getSuperclass() != Object.class) {
            fieldList.addAll(0, Arrays.asList(current.getDeclaredFields()));
            current = current.getSuperclass();
        }
        fieldList.addAll(0, Arrays.asList(current.getDeclaredFields()));
        return fieldList;
    }

}
