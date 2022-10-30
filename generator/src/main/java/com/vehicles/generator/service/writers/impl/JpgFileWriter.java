package com.vehicles.generator.service.writers.impl;

import com.vehicles.generator.controller.dto.VehicleDto;
import com.vehicles.generator.service.writers.AbstractFileWriter;

import java.util.List;

public class JpgFileWriter extends AbstractFileWriter {


    @Override
    protected String writeToFile(String type, List<VehicleDto> dtoList) {
        return type + ".jpg";
    }
}
