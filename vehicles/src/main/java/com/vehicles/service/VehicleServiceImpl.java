package com.vehicles.service;

import com.vehicles.controller.exception.exceptions.VehicleServiceException;
import com.vehicles.domain.Vehicle;
import com.vehicles.domain.constants.FileFormat;
import com.vehicles.repository.VehicleRepository;
import com.vehicles.service.reader.ApplicationFileReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> uploadDataFromFile(String filePath) {
        Utils.validateFileFormatOrThrowFileFormatException(filePath);
        String fileFormat = com.vehicles.service.utils.Utils.getFileFormat(filePath);
        ApplicationFileReader reader = getFileReader(fileFormat);
        return reader.readFile(filePath);
    }

    @Override
    public List<Vehicle> findAll() {
        return this.vehicleRepository.findAll();
    }

    @Override
    public Vehicle findById(String id) {
        UUID uuid = com.vehicles.service.utils.Utils.getUuidFromString(id);
        return this.vehicleRepository.findById(uuid)
                .orElseThrow(() -> new VehicleServiceException(String.format("Entity with id %s was not found in database", id)));
    }

    @Override
    public List<Vehicle> findByListOfBodyTypes(List<String> bodyTypes) {
        return this.vehicleRepository.findCarsByListOfBodyTypes(bodyTypes);
    }

    @Override
    public List<Vehicle> findByDateRange(String lower, String higher) {
        LocalDate start = Utils.parseDateOrThrowVehicleServiceException(lower);
        LocalDate end = Utils.parseDateOrThrowVehicleServiceException(higher);
        Date from = Date.valueOf(start);
        Date to = Date.valueOf(end);
        return this.vehicleRepository.findByDateRange(from, to);
    }

    @Override
    public List<Vehicle> findCarsReleasedBeforeDate(String date) {
        LocalDate localDate = Utils.parseDateOrThrowVehicleServiceException(date);
        return this.vehicleRepository.findCarsReleasedBeforeDate(Date.valueOf(localDate));
    }

    @Override
    public List<Vehicle> findTrucksReleasedAfterDate(String date) {
        LocalDate localDate = Utils.parseDateOrThrowVehicleServiceException(date);
        return this.vehicleRepository.findTrucksReleasedAfterDate(Date.valueOf(localDate));
    }
    private ApplicationFileReader getFileReader(String fileFormat) {
        ApplicationFileReader fileReader;
        try {
            fileReader = FileFormat.valueOf(fileFormat.toUpperCase()).getFileReader();
        } catch (IllegalArgumentException e) {
            throw new VehicleServiceException(String.format("No validator found for type: %s", fileFormat));
        }
        return fileReader;
    }

}
