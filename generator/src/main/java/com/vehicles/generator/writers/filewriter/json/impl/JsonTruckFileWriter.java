package com.vehicles.generator.writers.filewriter.json.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vehicles.generator.dto.TruckDto;
import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.exception.exceptions.JsonException;
import com.vehicles.generator.writers.filewriter.json.AbstractJsonFileWriter;

import java.util.ArrayList;
import java.util.List;

public class JsonTruckFileWriter extends AbstractJsonFileWriter {
    private static final String TRUCKS_JSON_FILE_PATH = "/TRUCKS.json";

    private final List<TruckDto> trucks;

    public JsonTruckFileWriter() {
        super();
        trucks = new ArrayList<>();
    }

    @Override
    public String write(List<VehicleDto> list) {
        for (VehicleDto dto : list) {
            trucks.add(buildDto(dto));
        }
        lineList.add(writeToJsonObject(trucks));
        return createFileAndReturnPath(TRUCKS_JSON_FILE_PATH);
    }

    private TruckDto buildDto(VehicleDto dto) {
        return TruckDto.builder()
                .type(dto.getType())
                .color(dto.getColor())
                .fabricationDate(dto.getFabricationDate())
                .loadingCapacity(dto.getLoadingCapacity())
                .build();
    }

    protected String writeToJsonObject(List<TruckDto> dto) {
        String jsonObject;
        try {
            jsonObject = objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            throw new JsonException("Write to JSON object fas failed");
        }
        return jsonObject;
    }

}
