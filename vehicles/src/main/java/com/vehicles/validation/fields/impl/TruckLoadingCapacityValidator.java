package com.vehicles.validation.fields.impl;

import com.vehicles.constants.MassUnit;
import com.vehicles.dto.request.VehicleStringInputDto;
import com.vehicles.validation.fields.FieldsValidator;

import java.util.Arrays;

import static com.vehicles.validation.ValidationUtils.LOADING_CAPACITY_REGEX;

public class TruckLoadingCapacityValidator extends FieldsValidator {

    @Override
    public boolean doValidate(VehicleStringInputDto vehicleDto) {
        boolean isValid = false;
        String loadingCapacity = vehicleDto.getLoadingCapacity();
        if (loadingCapacity.matches(LOADING_CAPACITY_REGEX)) {
            int load = Integer.parseInt(loadingCapacity.replaceAll("\\D", ""));
            String massUnit = loadingCapacity.replaceAll("\\d", "");
            boolean isValidMass = Arrays.stream(MassUnit.values())
                    .anyMatch(e -> e.name().equalsIgnoreCase(massUnit)
                            && e.getMaxWeight() > load);
            if (isValidMass) {
                isValid = true;
            }
        }
        return isValid;
    }

}
