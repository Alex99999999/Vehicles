package com.vehicles.generator.writers.filewriter.csv.impl;

import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.writers.filewriter.csv.AbstractCsvFileWriter;

import java.util.List;
import java.util.StringJoiner;

public class CsvCarFileWriter extends AbstractCsvFileWriter {

    private static final String CAR_CSV_FILE_PATH = "/CARS.csv";
    protected static final String CAR_HEADERS = "bodyType";

    @Override
    public String write(List<VehicleDto> dtoList) {
        setFields(dtoList, CAR_HEADERS);
        return createFileAndReturnPath(CAR_CSV_FILE_PATH);
    }

    @Override
    protected String setSpecificFields(VehicleDto dto) {
        return new StringJoiner(";")
                .add(dto.getBodyType())
                .toString();
    }

}
