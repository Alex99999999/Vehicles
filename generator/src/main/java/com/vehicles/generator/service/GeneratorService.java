package com.vehicles.generator.service;

import com.vehicles.generator.dto.VehicleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GeneratorService {

    List<String> generateFile(final Integer amount);

    List<VehicleDto> generateDtoList(final Integer amount);

}
