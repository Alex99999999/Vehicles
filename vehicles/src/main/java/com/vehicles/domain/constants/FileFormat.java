package com.vehicles.domain.constants;

import com.vehicles.service.reader.ApplicationFileReader;
import com.vehicles.service.reader.impl.CsvReader;
import com.vehicles.service.reader.impl.JsonReader;

import javax.script.CompiledScript;

public enum FileFormat {

    CSV(new CsvReader()),
    JSON(new JsonReader());

    private final ApplicationFileReader fileReader;

    FileFormat(ApplicationFileReader fileReader) {
        this.fileReader = fileReader;
    }

    public ApplicationFileReader getFileReader() {
        return fileReader;
    }
}
