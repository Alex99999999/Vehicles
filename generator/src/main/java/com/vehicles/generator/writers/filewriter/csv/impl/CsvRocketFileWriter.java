package com.vehicles.generator.writers.filewriter.csv.impl;

import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.writers.filewriter.csv.AbstractCsvFileWriter;

import java.util.List;

public class CsvRocketFileWriter extends AbstractCsvFileWriter {

    private static final String ROCKET_CSV_FILE_PATH = "/ROCKETS.csv";
    protected static final String ROCKET_HEADERS = "velocity";

    @Override
    public String write(List<VehicleDto> dtoList) {
        setFields(dtoList, ROCKET_HEADERS);
        return createFileAndReturnPath(ROCKET_CSV_FILE_PATH);
    }

    @Override
    protected String setSpecificFields(VehicleDto dto) {
        return "";
    }

}
