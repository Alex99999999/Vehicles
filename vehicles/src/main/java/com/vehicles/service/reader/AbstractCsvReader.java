package com.vehicles.service.reader;

import com.vehicles.domain.constants.VehicleType;
import com.vehicles.domain.Vehicle;
import com.vehicles.controller.exception.exceptions.VehicleServiceException;
import com.vehicles.service.validation.validators.impl.VehicleTypeValidator;
import com.vehicles.service.validation.chain.VehicleValidationChain;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.pool.TypePool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@RequiredArgsConstructor
public abstract class AbstractCsvReader implements ApplicationFileReader {
    protected static final String DELIMITER = ";";

    public List<Vehicle> getVehicles(String filePath) {
        String vehicleType = filePath.substring(0, filePath.indexOf("."));
        String fullPath = DEFAULT_FILE_PATH + filePath;
        List<Map<String, String>> listOfInputs = getMapOfValidatedValues(vehicleType, fullPath);
//        List<Vehicle> vehicles = mapToEntities(vehicleType,listOfInputs);

        return Collections.emptyList();
    }

    private List<Map<String, String>> getMapOfValidatedValues(String vehicleType, String fullPath) {
        List<String> lines = getFileContents(fullPath);
        String[] fields = lines.get(0).split(DELIMITER);
        Map<String, String> fieldValues = new HashMap<>();
        List<Map<String, String>> listOfMaps = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] values = lines.get(i).split(DELIMITER);
            if (values.length == fields.length) {
                for (int j = 0; j < values.length; j++) {
                    fieldValues.put(fields[j], values[j]);
                }
                boolean isValid = validateInputValues(vehicleType, fieldValues);
                if (isValid) {
                    listOfMaps.add(fieldValues);
                }
            }
        }
        return listOfMaps;
    }

    private boolean validateInputValues(String vehicleType, Map<String, String> fieldValues) {
        VehicleValidationChain validator = getValidator(vehicleType);
        validator.createValidatorsChain(new VehicleTypeValidator());
        return validator.validateFields(fieldValues);
    }

    private VehicleValidationChain getValidator(String vehicleType) {
        VehicleValidationChain validator;
        try {
            validator = VehicleType.valueOf(vehicleType.toUpperCase()).getValidator();
        } catch (IllegalArgumentException e) {
            throw new VehicleServiceException(String.format("No validator found for type: %s", vehicleType));
        }
        return validator;
    }

    private List<String> getFileContents(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new VehicleServiceException("Error reading CSV file");
        }
        return lines;
    }

}
