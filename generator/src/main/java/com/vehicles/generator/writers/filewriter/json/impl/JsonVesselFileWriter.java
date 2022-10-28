package com.vehicles.generator.writers.filewriter.json.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.dto.VesselDto;
import com.vehicles.generator.exception.exceptions.JsonException;
import com.vehicles.generator.writers.filewriter.json.AbstractJsonFileWriter;

import java.util.ArrayList;
import java.util.List;

public class JsonVesselFileWriter extends AbstractJsonFileWriter {

    private static final String VESSEL_JSON_FILE_PATH = "/VESSELS.json";

    private final List<VesselDto> vessels;

    public JsonVesselFileWriter() {
        super();
        vessels = new ArrayList<>();
    }

    @Override
    public String write(List<VehicleDto> list) {
        for (VehicleDto dto : list) {
            vessels.add(buildDto(dto));
        }
        lineList.add(writeToJsonObject(vessels));
        return createFileAndReturnPath(VESSEL_JSON_FILE_PATH);
    }

    private VesselDto buildDto(VehicleDto dto) {
        return VesselDto.builder()
                .type(dto.getType())
                .color(dto.getColor())
                .fabricationDate(dto.getFabricationDate())
                .build();
    }

    protected String writeToJsonObject(List<VesselDto> dto) {
        String jsonObject;
        try {
            jsonObject = objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            throw new JsonException("Write to JSON object fas failed");
        }
        return jsonObject;
    }

}
