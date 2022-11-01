package com.vehicles.service.validation.validators.impl;

import com.vehicles.domain.constants.MassUnit;
import com.vehicles.service.Utils;
import com.vehicles.service.validation.validators.FieldsValidator;

import java.util.Arrays;
import java.util.Map;

import static com.vehicles.domain.constants.Fields.TRUCK_LOADING_CAPACITY;

public class TruckLoadingCapacityValidator extends FieldsValidator {

    @Override
    public boolean doValidate(Map<String, String> fieldValues) {
        boolean isValid = false;
        String loadingCapacity = fieldValues.get(TRUCK_LOADING_CAPACITY);
        if (loadingCapacity.matches(Utils.LOADING_CAPACITY_REGEX)) {
            int load = Integer.parseInt(loadingCapacity.replaceAll("\\D", ""));
            String massUnit = loadingCapacity.replaceAll("\\d", "");
            boolean isValidMass = Arrays.stream(MassUnit.values())
                    .anyMatch(e -> e.name().equalsIgnoreCase(massUnit)
                            && e.getMaxWeight() > load);
            if (!isValidMass) {
                return false;
            }
        }
        return isValid(fieldValues);
    }

}
