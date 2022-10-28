package com.vehicles.generator.writers.filewriter;

import com.vehicles.generator.constants.FileFormat;
import com.vehicles.generator.writers.filewriter.csv.CsvVehiclesFileWriter;
import com.vehicles.generator.writers.filewriter.gif.GifVehiclesFileWriter;
import com.vehicles.generator.writers.filewriter.jpg.JpgVehiclesFileWriter;
import com.vehicles.generator.writers.filewriter.json.JsonVehiclesFileWriter;
import com.vehicles.generator.writers.filewriter.txt.TxtVehiclesFileWriter;

import java.util.HashMap;
import java.util.Map;

public class VehiclesFileWriterFormatHandler {

    private static final Map<String, FileCreator> map;

    static {
        map = new HashMap<>();
        map.putIfAbsent(FileFormat.CSV.name(), new CsvVehiclesFileWriter());
        map.putIfAbsent(FileFormat.JSON.name(), new JsonVehiclesFileWriter());
        map.putIfAbsent(FileFormat.JPG.name(), new JpgVehiclesFileWriter());
        map.putIfAbsent(FileFormat.TXT.name(), new TxtVehiclesFileWriter());
        map.putIfAbsent(FileFormat.GIF.name(), new GifVehiclesFileWriter());
    }

    public static FileCreator getFileWriter(String type) {
        return map.getOrDefault(type, new CsvVehiclesFileWriter());
    }

}
