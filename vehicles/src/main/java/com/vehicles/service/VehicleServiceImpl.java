package com.vehicles.service;

import com.vehicles.domain.Vehicle;
import com.vehicles.constants.FileFormat;
import com.vehicles.exception.exceptions.NoSuchEntityException;
import com.vehicles.repository.VehicleRepository;
import com.vehicles.validation.FileFormatValidator;
import com.vehicles.utils.Utils;
import com.vehicles.validation.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final FileFormatValidator fileFormatValidator;
    private final VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> uploadDataFromFile(String filePath) {
        final String errorMessage = String.format("Wrong file format. Supported formats %s", Arrays.toString(FileFormat.values()));
        boolean isFormatSupported = this.fileFormatValidator.isValid(filePath);
        if (!isFormatSupported) {
            throw new IllegalStateException(errorMessage);
        }
        return new ArrayList<>();
    }

    @Override
    public List<Vehicle> findAll() {
        return this.vehicleRepository.findAll();
    }

    @Override
    public Vehicle findById(String id) {
        UUID uuid = Utils.getUuidFromString(id);
        return this.vehicleRepository.findById(uuid)
                .orElseThrow(() -> new NoSuchEntityException(String.format("Entity with id %s was not found in database", id)));
    }

    @Override
    public List<Vehicle> findByListOfBodyTypes(List<String> bodyTypes) {
        return this.vehicleRepository.findCarsByListOfBodyTypes(bodyTypes);
    }

    @Override
    public List<Vehicle> findByDateRange(String lower, String higher) {
        LocalDate start = ValidationUtils.validateDateOrThrowDateFormatException(lower);
        LocalDate end = ValidationUtils.validateDateOrThrowDateFormatException(higher);
        Date from = Date.valueOf(start);
        Date to = Date.valueOf(end);
        return this.vehicleRepository.findByDateRange(from, to);
    }

    @Override
    public List<Vehicle> findCarsReleasedBeforeDate(String date) {
        LocalDate localDate = ValidationUtils.validateDateOrThrowDateFormatException(date);
        return this.vehicleRepository.findCarsReleasedBeforeDate(Date.valueOf(localDate));
    }

    @Override
    public List<Vehicle> findTrucksReleasedAfterDate(String date) {
        LocalDate localDate = ValidationUtils.validateDateOrThrowDateFormatException(date);
        return this.vehicleRepository.findTrucksReleasedAfterDate(Date.valueOf(localDate));
    }

}
