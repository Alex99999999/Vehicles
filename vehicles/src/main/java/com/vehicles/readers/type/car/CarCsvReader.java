package com.vehicles.readers.type.car;

import com.vehicles.domain.Vehicle;
import com.vehicles.dto.request.VehicleStringInputDto;
import com.vehicles.exception.exceptions.FileFormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarCsvReader extends AbstractCsvReader{
    @Override
    public List<Vehicle> parseFile(File file) {
        List<VehicleStringInputDto> inputData = new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C/Pet/storage/CARS.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(DELIMITER);
                VehicleStringInputDto dto = mapToStringDto();
            }
        }catch (IOException ex) {
            throw new FileFormatException(String.format("Error while reading file %s", file.getAbsolutePath()));
        };




    }
}
