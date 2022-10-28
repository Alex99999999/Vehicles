package com.vehicles.validation;

import com.vehicles.exception.exceptions.DateFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidationUtils {

    public static final String DATE_REGEX = "^\\d{4}\\D\\d{2}\\D\\d{2}$";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String RGB_COLOR_REGEX = "^rgb\\(\\s*(0|[1-9]\\d?|1\\d\\d?|2[0-4]\\d|25[0-5])%?\\s*,\\s*(0|[1-9]\\d?|1\\d\\d?|2[0-4]\\d|25[0-5])%?\\s*,\\s*(0|[1-9]\\d?|1\\d\\d?|2[0-4]\\d|25[0-5])%?\\s*\\)$";
    public static final String LOADING_CAPACITY_REGEX = "^\\d{1,5}\\w{2}$";

    public static LocalDate validateDateOrThrowDateFormatException(String date) {
        LocalDate localDate;
        RuntimeException exception = new DateFormatException(String.format("Invalid date format. Should be %s", DATE_PATTERN));
        if (!date.matches(DATE_REGEX)) {
            throw exception;
        }
        String formatted = date.replaceAll("\\D", "-");
        try {
            localDate = LocalDate.parse(formatted, DateTimeFormatter.ofPattern(DATE_PATTERN));
        } catch (DateTimeParseException e) {
            throw exception;
        }
        return localDate;
    }

}
