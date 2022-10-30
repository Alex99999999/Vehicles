package com.vehicles.readers.format;

import com.vehicles.constants.FileFormat;
import com.vehicles.exception.exceptions.NoSuchReader;
import com.vehicles.readers.format.impl.CsvReader;
import com.vehicles.readers.format.impl.JsonReader;

import java.util.HashMap;
import java.util.Map;

import static com.vehicles.exception.Messages.NO_SUCH_READER;

public class FormatFileReaderContainer {

    private static Map<String, AbstractFormatFileReader> map;

    static {
        map = new HashMap<>();
        map.put(FileFormat.CSV.name(), new CsvReader());
        map.put(FileFormat.JSON.name(), new JsonReader());
    }

    public static AbstractFormatFileReader getFormatFileReader(String format) {
        AbstractFormatFileReader fileReader = map.get(format.toUpperCase());
        if (fileReader == null) {
            throw new NoSuchReader(String.format(NO_SUCH_READER, format));
        }
        return fileReader;
    }

}
