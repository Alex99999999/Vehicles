package com.vehicles.service;

import com.vehicles.domain.constants.FileFormat;
import com.vehicles.controller.exception.exceptions.VehicleServiceException;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class Utils {

    public static final String DATE_REGEX = "^\\d{4}\\D\\d{2}\\D\\d{2}$";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String RGB_COLOR_REGEX = "^rgb\\(\\s*(0|[1-9]\\d?|1\\d\\d?|2[0-4]\\d|25[0-5])%?\\s*,\\s*(0|[1-9]\\d?|1\\d\\d?|2[0-4]\\d|25[0-5])%?\\s*,\\s*(0|[1-9]\\d?|1\\d\\d?|2[0-4]\\d|25[0-5])%?\\s*\\)$";
    public static final String LOADING_CAPACITY_REGEX = "^\\d{1,5}\\w{2}$";

    public static LocalDate parseDateOrThrowVehicleServiceException(String date) {
        LocalDate localDate;
        RuntimeException exception = new VehicleServiceException(String.format("Invalid date format. Should be %s", DATE_PATTERN));
        String formatted = date.replaceAll("\\D", "-");
        try {
            localDate = LocalDate.parse(formatted, DateTimeFormatter.ofPattern(DATE_PATTERN));
        } catch (DateTimeParseException e) {
            throw exception;
        }
        return localDate;
    }

    public static boolean validateDate(String date) {
        return date.matches(DATE_REGEX);
    }

    public static void validateFileFormatOrThrowFileFormatException(String filePath) {
        final String errorMessage = String.format("Wrong file format. Supported formats %s", Arrays.toString(FileFormat.values()));
        boolean isValid = false;
        if (!filePath.isBlank()) {
            String fileFormat = filePath.substring(filePath.lastIndexOf(".") + 1);
            isValid = Arrays.stream(FileFormat.values())
                    .anyMatch(e -> e.name().equalsIgnoreCase(fileFormat));
        }
        if (!isValid) {
            throw new IllegalStateException(errorMessage);
        }
    }

    public static void validateFileOrThrowException(File file) {
        if (file != null && !file.exists()) {
            throw new VehicleServiceException(String.format("File does not exist %s", file.getAbsolutePath()));
        }
        if (file != null && !file.isFile()) {
            throw new VehicleServiceException(String.format("File cannot be parsed %s", file.getAbsolutePath()));
        }
    }
}
