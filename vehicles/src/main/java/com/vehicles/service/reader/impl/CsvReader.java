package com.vehicles.service.reader.impl;

import com.vehicles.controller.dto.VehicleRequestDto;
import com.vehicles.service.reader.AbstractCsvReader;

import java.util.List;

public class CsvReader extends AbstractCsvReader {

    @Override
    public List<VehicleRequestDto> readFile(String filePath) {
        getVehicles(filePath);
        return null;
    }

}
