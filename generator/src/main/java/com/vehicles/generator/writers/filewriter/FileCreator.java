package com.vehicles.generator.writers.filewriter;

import com.vehicles.generator.dto.VehicleDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface FileCreator {

    List<String> writeFile(Map<String, List<VehicleDto>> mapOfTypes);

}
