package com.vehicles.service;

import com.vehicles.domain.Vehicle;
import com.vehicles.domain.constants.FileFormat;
import com.vehicles.exception.exceptions.NoSuchEntityException;
import com.vehicles.repository.VehicleRepository;
import com.vehicles.validation.FileFormatValidatorPlain;
import com.vehicles.validation.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final FileFormatValidatorPlain fileFormatValidator;
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
        UUID uuid = ValidationUtils.validateUuid(id);
        return this.vehicleRepository.findById(uuid)
                .orElseThrow(() -> new NoSuchEntityException(String.format("Entity with id %s was not found in database", id)));
    }

    @Override
    public List<Vehicle> findByListOfBodyTypes(List<String> bodyTypes) {
        return this.vehicleRepository.findByListOfBodyTypes(bodyTypes);
    }


}
