package com.vehicles.generator.writers.filewriter;

import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.exception.exceptions.FileWriteException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public abstract class AbstractFileWriter {

    protected String defaultFilePath = "C:/Pet/storage";
    protected List<String> lineList;

    public AbstractFileWriter() {
        lineList = new ArrayList<>();
    }

    public abstract String write(List<VehicleDto> list);

    protected String createFileAndReturnPath(String csvFilePath) {
        String path = this.defaultFilePath + csvFilePath;
        File csvFile = new File(path);
        try (FileWriter writer = new FileWriter(csvFile)) {
            for (String line : lineList) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            throw new FileWriteException("Error while writing into file occurred");
        }
        return path;
    }

}
