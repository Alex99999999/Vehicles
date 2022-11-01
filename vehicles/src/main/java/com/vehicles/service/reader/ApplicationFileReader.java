package com.vehicles.service.reader;

import com.vehicles.domain.Vehicle;

import java.util.List;

public interface ApplicationFileReader {

    String DEFAULT_FILE_PATH = "C:/Pet/storage/";
    List<Vehicle> readFile(String file);

}
