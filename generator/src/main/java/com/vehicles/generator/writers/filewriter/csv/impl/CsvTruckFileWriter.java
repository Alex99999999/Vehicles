package com.vehicles.generator.writers.filewriter.csv.impl;

import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.writers.filewriter.csv.AbstractCsvFileWriter;

import java.util.List;
import java.util.StringJoiner;

public class CsvTruckFileWriter extends AbstractCsvFileWriter {

    private static final String TRUCK_CSV_FILE_PATH = "/TRUCKS.csv";
    protected static final String TRUCK_HEADERS = "loadingCapacity";

    @Override
    public String write(List<VehicleDto> dtoList) {
        setFields(dtoList, TRUCK_HEADERS);
        return createFileAndReturnPath(TRUCK_CSV_FILE_PATH);
    }

    @Override
    protected String setSpecificFields(VehicleDto dto) {
        return new StringJoiner(";")
                .add(dto.getLoadingCapacity())
                .toString();
    }

}
