package com.vehicles.generator.utils;

import com.vehicles.generator.constants.FileFormat;
import com.vehicles.generator.constants.VehicleType;
import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.service.vehiclegenerator.VehiclesTypeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RandomFieldValuesGenerator {

    private final VehiclesTypeGenerator vehiclesTypeGenerator;

    public VehicleDto generateDto() {
        String vehicleType = peekVehicleType();
        String color = generateRgbColor();
        String fabricationDate = generateFabricationDate();
        VehicleDto vehicleDto = VehicleDto.builder()
                .type(vehicleType)
                .color(color)
                .fabricationDate(fabricationDate)
                .build();
        this.vehiclesTypeGenerator.getVehiclesGenerators().get(vehicleType).setSpecificFields(vehicleDto);
        return vehicleDto;
    }

    private String generateFabricationDate() {
        int yyyy = GeneratorUtils.getRandomInt(1970, 2050);
        int month = GeneratorUtils.getRandomInt(1, 13);
        int day = GeneratorUtils.getRandomInt(1, 30);
        String mm = month < 10 ? "" + 0 + month : String.valueOf(month);
        String dd = day < 10 ? "" + 0 + day : String.valueOf(month);
        return String.format("%d-%s-%s", yyyy, mm, dd);
    }

    private String generateRgbColor() {
        String colorFormat = "rgb(%d, %d, %d)";
        int red = GeneratorUtils.getRandomInt(0, 500);
        int green = GeneratorUtils.getRandomInt(0, 266);
        int blue = GeneratorUtils.getRandomInt(0, 266);
        return String.format(colorFormat, red, green, blue);
    }

    private String peekVehicleType() {
        int randomIndex = GeneratorUtils.getRandomInt(0, VehicleType.values().length);
        return VehicleType.values()[randomIndex].name();
    }

    public String peekFileFormat() {
        int randomIndex = GeneratorUtils.getRandomInt(0, FileFormat.values().length);
        return FileFormat.values()[randomIndex].name();
    }


}
