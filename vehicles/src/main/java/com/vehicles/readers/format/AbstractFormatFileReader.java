package com.vehicles.readers.format;

import com.vehicles.domain.Vehicle;
import com.vehicles.validation.ValidationUtils;

import java.io.File;
import java.util.List;

public abstract class AbstractFormatFileReader {

    public abstract List<Vehicle> readFile(String filePath);

    protected File getValidatedFile(String filePath) {
        File file = new File(filePath);
        ValidationUtils.validateFileOrThrowException(file);
        return file;
    }

}
