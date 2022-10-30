package com.vehicles.readers.type.car;

import com.vehicles.constants.VehicleType;
import com.vehicles.exception.exceptions.NoSuchReader;

import java.util.HashMap;
import java.util.Map;

import static com.vehicles.exception.Messages.NO_SUCH_READER;

public class CsvReadersContainer {

    private static final Map<String, AbstractCsvReader> csvReaders;

    static {
        csvReaders = new HashMap<>();
        csvReaders.put(VehicleType.CAR.name(), new CarCsvReader());
        csvReaders.put(VehicleType.TRUCK.name(), new TruckCsvReader());
    }

    public static AbstractCsvReader getCsvReader(String vehicleType) {
        AbstractCsvReader csvReader = csvReaders.get(vehicleType);
        if (csvReader == null) {
            throw new NoSuchReader(String.format(NO_SUCH_READER, vehicleType));
        }
        return csvReader;
    }

}
