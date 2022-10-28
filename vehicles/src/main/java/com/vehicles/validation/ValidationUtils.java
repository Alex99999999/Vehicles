package com.vehicles.validation;

import java.util.UUID;

public class ValidationUtils {

    public static UUID validateUuid(String stringUuid) {
        return UUID.fromString(stringUuid);
    }

}
