package com.vehicles.validation;

import com.vehicles.annotation.ValidateFileFormat;
import com.vehicles.domain.constants.FileFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class FileFormatValidator implements ConstraintValidator<ValidateFileFormat, String> {

    private final String errorMessage = String.format("Wrong file format %s", Arrays.toString(FileFormat.values()));

    @Override
    public boolean isValid(String filePath, ConstraintValidatorContext context) {
        boolean isValid = false;
        if (!filePath.isBlank()) {
            String fileFormat = filePath.substring(filePath.lastIndexOf(".") + 1);
            isValid = Arrays.stream(FileFormat.values())
                    .anyMatch(e -> e.name().equalsIgnoreCase(fileFormat));
        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMessage)
                    .addConstraintViolation();
        }
        return isValid;
    }

    //TODO delete
    public static void main(String[] args) {
        System.out.println(FileFormat.CSV.name());
//        Arrays.toString(FileFormat.values());
        System.out.println(Arrays.toString(FileFormat.values()));
    }

}
