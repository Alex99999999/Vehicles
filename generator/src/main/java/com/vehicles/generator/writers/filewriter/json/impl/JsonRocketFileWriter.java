package com.vehicles.generator.writers.filewriter.json.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vehicles.generator.dto.RocketDto;
import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.exception.exceptions.JsonException;
import com.vehicles.generator.writers.filewriter.json.AbstractJsonFileWriter;

import java.util.ArrayList;
import java.util.List;

public class JsonRocketFileWriter extends AbstractJsonFileWriter {
    private static final String ROCKETS_JSON_FILE_PATH = "/ROCKETS.json";

    private final List<RocketDto> rockets;

    public JsonRocketFileWriter() {
        super();
        rockets = new ArrayList<>();
    }

    @Override
    public String write(List<VehicleDto> list) {
        for (VehicleDto dto : list) {
            rockets.add(buildRocketDto(dto));
        }
        lineList.add(writeToJsonObject(rockets));
        return createFileAndReturnPath(ROCKETS_JSON_FILE_PATH);
    }

    private RocketDto buildRocketDto(VehicleDto dto) {
        return RocketDto.builder()
                .type(dto.getType())
                .color(dto.getColor())
                .fabricationDate(dto.getFabricationDate())
                .velocity(dto.getBodyType())
                .build();
    }

    protected String writeToJsonObject(List<RocketDto> dto) {
        String jsonObject;
        try {
            jsonObject = objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            throw new JsonException("Write to JSON object fas failed");
        }
        return jsonObject;
    }

}
