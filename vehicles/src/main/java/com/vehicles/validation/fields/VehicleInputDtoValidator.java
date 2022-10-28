package com.vehicles.validation.fields;


import com.vehicles.dto.request.VehicleStringInputDto;

public class VehicleInputDtoValidator {

    private final FieldsValidator validator;
    private final VehicleStringInputDto vehicleDto;

    public VehicleInputDtoValidator(FieldsValidator validator,
                                    VehicleStringInputDto vehicleDto) {
        this.validator = validator;
        this.vehicleDto = vehicleDto;
    }

    public boolean isValid() {
        return validator.doValidate(vehicleDto);
    }

}
