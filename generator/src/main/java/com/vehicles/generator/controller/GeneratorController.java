package com.vehicles.generator.controller;

import com.vehicles.generator.controller.dto.VehicleDto;
import com.vehicles.generator.service.generator.GeneratorService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GeneratorController {

    private final GeneratorService generatorService;

    @GetMapping("/file/{amount}")
    List<String> generateFiles(@PathVariable @NonNull Integer amount) {
        return this.generatorService.generateFilePaths(amount);
    }

    @GetMapping("/{amount}")
    List<VehicleDto> getGeneratedVehicles(@PathVariable @NonNull Integer amount) {
        return this.generatorService.generateDtoList(amount);
    }

}
