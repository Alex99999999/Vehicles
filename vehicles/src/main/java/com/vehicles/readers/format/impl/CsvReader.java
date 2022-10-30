package com.vehicles.readers.format.impl;

import com.vehicles.domain.Vehicle;
import com.vehicles.readers.format.AbstractFormatFileReader;
import com.vehicles.readers.type.car.AbstractCsvReader;
import com.vehicles.readers.type.car.CsvReadersContainer;

import java.io.File;
import java.util.List;

public class CsvReader extends AbstractFormatFileReader {


    @Override
    public List<Vehicle> readFile(String filePath) {
        File file = getValidatedFile(filePath);
        String vehicleType = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.lastIndexOf("."));
        AbstractCsvReader csvReader = CsvReadersContainer.getCsvReader(vehicleType);
        return csvReader.parseFile(file);
    }

}
