package com.vehicles.generator.service.generator;

import com.vehicles.generator.controller.dto.VehicleDto;

import java.util.List;


public interface GeneratorService {

    List<String> generateFilePaths(Integer amount);

    List<VehicleDto> generateDtoList(Integer amount);

}
