package com.vehicles.generator.service.writers;

import com.vehicles.generator.exception.exceptions.GeneratorException;
import com.vehicles.generator.service.writers.impl.CsvFileWriter;
import com.vehicles.generator.service.writers.impl.JpgFileWriter;
import com.vehicles.generator.service.writers.impl.JsonFileWriter;
import com.vehicles.generator.service.writers.impl.TxtFileWriter;
import com.vehicles.generator.service.constants.FileFormat;

import java.util.HashMap;
import java.util.Map;

public class FileWritersContainer {

    private static final Map<String, AbstractFileWriter> map;

    static {
        map = new HashMap<>();
        map.put(FileFormat.CSV.name(), new CsvFileWriter());
        map.put(FileFormat.JSON.name(), new JsonFileWriter());
        map.put(FileFormat.JPG.name(), new JpgFileWriter());
        map.put(FileFormat.TXT.name(), new TxtFileWriter());
    }

    public static AbstractFileWriter getFileWriter(String vehicleType) {
        AbstractFileWriter writer = map.get(vehicleType);
        if (writer == null) {
            throw new GeneratorException(String.format("No writer for file type %s", vehicleType));
        }
        return writer;
    }

}
