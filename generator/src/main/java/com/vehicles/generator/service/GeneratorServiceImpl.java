package com.vehicles.generator.service;

import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.utils.RandomFieldValuesGenerator;
import com.vehicles.generator.writers.filewriter.FileCreator;
import com.vehicles.generator.writers.filewriter.VehiclesFileWriterFormatHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class GeneratorServiceImpl implements GeneratorService {

    private final RandomFieldValuesGenerator fieldValuesGenerator;

    @Override
    public List<String> generateFile(Integer amount) {
        String fileFormat = fieldValuesGenerator.peekFileFormat();
        List<VehicleDto> vehicleDtoList = generateDtoList(amount);
        Map<String, List<VehicleDto>> mapOfTypes = new HashMap<>();
        for (VehicleDto dto : vehicleDtoList) {
            String vehicleType = dto.getType();
            mapOfTypes.putIfAbsent(vehicleType, new ArrayList<>());
            mapOfTypes.get(vehicleType).add(dto);
        }
        FileCreator fileCreator = VehiclesFileWriterFormatHandler.getFileWriter(fileFormat);
        return fileCreator.writeFile(mapOfTypes);
    }

    @Override
    public List<VehicleDto> generateDtoList(Integer amount) {
        if (amount < 2 || amount > 10_000) {
            throw new IllegalArgumentException("You can generate min 1 and max 10_000 objects at a time");
        }
        List<VehicleDto> vehicleDtoList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            vehicleDtoList.add(fieldValuesGenerator.generateDto());
        }
        return vehicleDtoList;
    }

}
