package com.vehicles.service.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Utils {

    public static UUID getUuidFromString(String stringUuid) {
        return UUID.fromString(stringUuid);
    }

    public static String getFileFormat(String filePath) {
        return filePath.substring(filePath.lastIndexOf(".") + 1);
    }
}
