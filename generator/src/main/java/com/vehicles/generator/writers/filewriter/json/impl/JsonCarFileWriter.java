package com.vehicles.generator.writers.filewriter.json.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vehicles.generator.dto.CarDto;
import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.exception.exceptions.JsonException;
import com.vehicles.generator.writers.filewriter.json.AbstractJsonFileWriter;

import java.util.ArrayList;
import java.util.List;

public class JsonCarFileWriter extends AbstractJsonFileWriter {

    private static final String CAR_JSON_FILE_PATH = "/CARS.json";
    private final  List<CarDto> cars;

    public JsonCarFileWriter() {
        super();
        cars = new ArrayList<>();
    }

    @Override
    public String write(List<VehicleDto> list) {
        for (VehicleDto dto : list) {
            cars.add(buildCarDto(dto));
        }
        lineList.add(writeToJsonObject(cars));
        return createFileAndReturnPath(CAR_JSON_FILE_PATH);
    }

    private CarDto buildCarDto(VehicleDto dto) {
        return CarDto.builder()
                .type(dto.getType())
                .color(dto.getColor())
                .fabricationDate(dto.getFabricationDate())
                .bodyType(dto.getBodyType())
                .build();
    }

    protected String writeToJsonObject(List<CarDto> dto) {
        String jsonObject;
        try {
            jsonObject = objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            throw new JsonException("Write to JSON object fas failed");
        }
        return jsonObject;
    }

}
