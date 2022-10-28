package com.vehicles.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Utils {

    public static UUID getUuidFromString(String stringUuid) {
        return UUID.fromString(stringUuid);
    }

}
