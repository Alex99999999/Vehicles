package com.vehicles.generator.writers.filewriter.csv.impl;

import com.vehicles.generator.constants.VehicleType;
import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.writers.filewriter.csv.AbstractCsvFileWriter;

import java.util.List;

public class CsvVesselFileWriter extends AbstractCsvFileWriter {

    private static final String VESSEL_CSV_FILE_PATH = "/VESSELS.csv";
    protected static final String VESSEL_HEADERS = "capacity";

    @Override
    public String write(List<VehicleDto> dtoList) {
        setFields(dtoList, VESSEL_HEADERS);
        return createFileAndReturnPath(VESSEL_CSV_FILE_PATH);
    }

    @Override
    protected String setSpecificFields(VehicleDto dto) {
        return "";
    }

}
