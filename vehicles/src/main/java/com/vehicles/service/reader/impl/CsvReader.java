package com.vehicles.service.reader.impl;

import com.vehicles.domain.Vehicle;
import com.vehicles.service.reader.AbstractCsvReader;


import java.util.List;

public class CsvReader extends AbstractCsvReader {

    @Override
    public List<Vehicle> readFile(String filePath) {
        return getVehicles(filePath);
    }

}
