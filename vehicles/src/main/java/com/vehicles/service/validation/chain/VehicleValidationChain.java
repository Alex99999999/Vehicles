package com.vehicles.service.validation.chain;

import com.vehicles.service.validation.validators.FieldsValidator;
import com.vehicles.service.validation.validators.impl.RgbColorValidator;
import com.vehicles.service.validation.validators.impl.DateValidator;

import java.util.List;
import java.util.Map;

public abstract class VehicleValidationChain {
    protected FieldsValidator fieldsValidator;

    protected VehicleValidationChain() {
    }

    protected abstract void linkSpecificValidators(FieldsValidator fieldsValidator);

    public boolean validateFields(Map<String, String> fieldValues) {
        return this.fieldsValidator.doValidate(fieldValues);
    }
    public void createValidatorsChain(FieldsValidator firstValidator) {
        this.fieldsValidator = firstValidator;
        List<FieldsValidator> list = List.of(
                new RgbColorValidator(),
                new DateValidator()
        );
        fieldsValidator.link(fieldsValidator, list);
        linkSpecificValidators(list.get(list.size() - 1));
    }

}
