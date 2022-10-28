package com.vehicles.generator.writers.filewriter.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.exception.exceptions.FileWriteException;
import com.vehicles.generator.exception.exceptions.JsonException;
import com.vehicles.generator.writers.filewriter.AbstractFileWriter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Component
public abstract class AbstractJsonFileWriter extends AbstractFileWriter {

    protected ObjectMapper objectMapper;

    public AbstractJsonFileWriter() {
        objectMapper = new ObjectMapper();
    }

    public abstract String write(List<VehicleDto> list);

}
