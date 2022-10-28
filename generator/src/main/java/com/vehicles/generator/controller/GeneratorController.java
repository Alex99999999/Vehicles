package com.vehicles.generator.controller;

import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.service.GeneratorService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GeneratorController {

    private final GeneratorService generatorService;

    @GetMapping("/file/{amount}")
    List<String> generateFiles(@PathVariable @NonNull Integer amount) {
        return this.generatorService.generateFile(amount);
    }

    @GetMapping("/{amount}")
    List<VehicleDto> getGeneratedVehicles(@PathVariable @NonNull Integer amount) {
        return this.generatorService.generateDtoList(amount);
    }

}
