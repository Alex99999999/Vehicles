package com.vehicles.readers.type.car;

import com.vehicles.domain.Vehicle;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractCsvReader {

    protected static final String HEADERS = "number;type;color;fabricationDate;";
    protected static final String DELIMITER = ";";

    protected static final  Map<String, String> headersFieldsMatcher;

    static {
        headersFieldsMatcher = new HashMap<>();
        headersFieldsMatcher.put("number", "");
        headersFieldsMatcher.put("type", "type");
        headersFieldsMatcher.put("color", "color");
        headersFieldsMatcher.put("fabricationDate", "fabricationDate");;
    }

    public abstract List<Vehicle> parseFile(File file);

}
