package com.vehicles.generator.service.generator;

import com.vehicles.generator.controller.dto.VehicleDto;
import com.vehicles.generator.service.writers.AbstractFileWriter;
import com.vehicles.generator.service.writers.FileWritersContainer;
import com.vehicles.generator.service.constants.FileFormat;
import com.vehicles.generator.service.constants.VehicleType;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class AbstractGeneratorService implements GeneratorService {

    protected VehicleDto vehicleDto;

    public abstract VehicleDto generateSpecificFields(VehicleDto dto);

    @Override
    public List<String> generateFilePaths(Integer amount) {
        List<VehicleDto> vehicleDtoList = generateDtoList(amount);
        Map<String, List<VehicleDto>> mapOfTypes = vehicleDtoList.stream()
                .collect(Collectors.groupingBy(VehicleDto::getType));

        String fileFormat = generateFileFormat();
        AbstractFileWriter fileWriter = FileWritersContainer.getFileWriter(fileFormat);
        return fileWriter.writeAllIntoAppropriateFiles(mapOfTypes);
    }

    @Override
    public List<VehicleDto> generateDtoList(Integer amount) {
        List<VehicleDto> vehicleDtoList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            vehicleDtoList.add(generateDto());
        }
        return vehicleDtoList;
    }

    private VehicleDto generateDto() {
        String vehicleType = generateVehicleType();
        generateCommonFields(vehicleType);
        AbstractGeneratorService dtoGenerator = VehicleGeneratorsHandler.getVehicleGenerator(vehicleType);
        return dtoGenerator.generateSpecificFields(this.vehicleDto);
    }

    private void generateCommonFields(String vehicleType) {
        this.vehicleDto = VehicleDto.builder()
                .type(vehicleType)
                .color(generateRgbColor())
                .fabricationDate(generateFabricationDate())
                .build();
    }

    private String generateFabricationDate() {
        int yyyy = getRandomInt(1970, 2050);
        int month = getRandomInt(1, 13);
        int day = getRandomInt(1, 30);
        String mm = month < 10 ? "" + 0 + month : String.valueOf(month);
        String dd = day < 10 ? "" + 0 + day : String.valueOf(month);
        return String.format("%d-%s-%s", yyyy, mm, dd);
    }

    private String generateRgbColor() {
        String colorFormat = "rgb(%d, %d, %d)";
        int red = getRandomInt(0, 500);
        int green = getRandomInt(0, 266);
        int blue = getRandomInt(0, 266);
        return String.format(colorFormat, red, green, blue);
    }

    private String generateVehicleType() {
        int randomIndex = getRandomInt(0, VehicleType.values().length);
        return VehicleType.values()[randomIndex].name();
    }

    public String generateFileFormat() {
        int randomIndex = getRandomInt(0, FileFormat.values().length);
        return FileFormat.values()[randomIndex].name();
    }

    private static int getRandomInt(int startInclusive, int endExclusive) {
        return new Random().nextInt(startInclusive, endExclusive);
    }

}
