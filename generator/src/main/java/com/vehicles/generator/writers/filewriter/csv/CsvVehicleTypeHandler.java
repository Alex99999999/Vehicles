package com.vehicles.generator.writers.filewriter.csv;

import com.vehicles.generator.constants.VehicleType;
import com.vehicles.generator.exception.exceptions.NoSuchWriterException;
import com.vehicles.generator.writers.filewriter.csv.impl.CsvCarFileWriter;
import com.vehicles.generator.writers.filewriter.csv.impl.CsvRocketFileWriter;
import com.vehicles.generator.writers.filewriter.csv.impl.CsvTruckFileWriter;
import com.vehicles.generator.writers.filewriter.csv.impl.CsvVesselFileWriter;

import java.util.HashMap;
import java.util.Map;

public class CsvVehicleTypeHandler {

    private static final Map<String, AbstractCsvFileWriter> map;

    static {
        map = new HashMap<>();
        map.put(VehicleType.CAR.name(), new CsvCarFileWriter());
        map.put(VehicleType.TRUCK.name(), new CsvTruckFileWriter());
        map.put(VehicleType.VESSEL.name(), new CsvVesselFileWriter());
        map.put(VehicleType.ROCKET.name(), new CsvRocketFileWriter());
    }

    static AbstractCsvFileWriter getCsvWriter(String vehicleType) {
        AbstractCsvFileWriter writer = map.get(vehicleType);
        if (writer == null) {
            throw new NoSuchWriterException(String.format("No CSV writer for vehicle type vehicleType %S", vehicleType));
        }
        return writer;
    }

}
