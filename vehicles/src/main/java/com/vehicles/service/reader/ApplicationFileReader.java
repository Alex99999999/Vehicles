package com.vehicles.service.reader;

import com.vehicles.controller.dto.VehicleRequestDto;

import java.util.List;

public interface ApplicationFileReader {

    String DEFAULT_FILE_PATH = "C:/Pet/storage/";
    List<VehicleRequestDto> readFile(String file);

}
